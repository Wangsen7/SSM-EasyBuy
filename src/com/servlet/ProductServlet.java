package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;
import com.entity.Product;
import com.entity.ProductCategory;
import com.entity.User;
import com.service.ProductCategoryService;
import com.service.ProductService;
import com.service.impl.ProductCategoryServiceImpl;
import com.service.impl.ProductServiceImpl;
import com.util.HistoryProduct;
import com.util.Page;
import com.util.ProductCaPage;
import com.util.ProductCategoryVo;

public class ProductServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		ProductService productService=new ProductServiceImpl();
		String currentPageNo=request.getParameter("currentPageNo");
		String pro=request.getParameter("pro");
		HttpSession session=request.getSession();
		ProductCategoryService procate=new ProductCategoryServiceImpl();
		if(pro==null){
			String id=request.getParameter("id");
			
			Product product=productService.selByid(Integer.parseInt(id));
			
			//浏览历史商品
			HistoryProduct historyProduct=null;
			if(session.getAttribute("historyProduct")!=null){
				historyProduct=(HistoryProduct)session.getAttribute("historyProduct");
			}else{
				historyProduct=new HistoryProduct();
			}
			historyProduct.add(product);
			session.setAttribute("historyProduct", historyProduct);
			request.setAttribute("product",product);
			//三级所有商品信息
			ProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
			List<ProductCategoryVo> vos=productCategoryService.selAll();
			request.setAttribute("vos",vos);
			request.getRequestDispatcher("product.jsp").forward(request, response);
			
			
				
		}else if(pro.equals("last")){
			//末页
			String s=request.getParameter("currPageNo");
			Page pcg=productService.sellpage(Integer.parseInt(s));		
			request.setAttribute("pcg",pcg);
			
			request.getRequestDispatcher("HTshoppingxx.jsp").forward(request, response);
			
			
		}else if(pro.equals("spxx")){
			if(currentPageNo==null){
				currentPageNo="1";
			}		
			Page pcg=productService.sellpage(Integer.parseInt(currentPageNo));		
			request.setAttribute("pcg",pcg);
			request.getRequestDispatcher("HTshoppingxx.jsp").forward(request, response);
			
		}else if(pro.equals("spxxo")){
			String s=request.getParameter("currPageNo");
			Page pcg=productService.sellpage(Integer.parseInt(s));		
			request.setAttribute("pcg",pcg);
			request.getRequestDispatcher("HTshoppingxx.jsp").forward(request, response);
			
		}else if(pro.equals("shangpingDe")){
			User user=(User)session.getAttribute("user");
			if(user.getType()!=1){
				out.print("<script>alert(\"您不是管理员，无法进行操作！\");location.href=\"ProductServlet?pro=spxx\"</script>");
			}else{
				int id=Integer.parseInt(request.getParameter("id"));
				int line=productService.deleteSp(id);
				if(line>0){			
					out.print("<script>alert(\"删除成功\");location.href=\"ProductServlet?pro=spxx\"</script>");
				}
			}
			/**
			 * 添加分类
			 */
		}else if(pro.equals("tianjiafenlei")){
			String name=request.getParameter("name");
			int parentId=Integer.parseInt(request.getParameter("parentId"));
			int type=Integer.parseInt(request.getParameter("type1"));
			int sf=procate.add(name, parentId, type);
			out.print(sf);
		}else if(pro.equals("tianjiafenleiid")){
			int parentId=Integer.parseInt(request.getParameter("parentId"));
			List<ProductCategory> list=procate.selByParentId(parentId);
			String jso=JSON.toJSONString(list);
			out.print(jso);
		}else if(pro.equals("shangpingtianjia")){
			
			String name1="";
			String description="";
			float price=0;
			int stock=0;
			String fileName="";		
			int categoryLevel1Id=0;
			int categoryLevel2Id=0;
			int categoryLevel3Id=0;
			String savePath = this.getServletContext().getRealPath("/files");
            File file = new File(savePath);
              //判断上传文件的保存目录是否存在
             if (!file.exists() && !file.isDirectory()) {
                System.out.println(savePath+"目录不存在，需要创建");
                  //创建目录
             file.mkdir();
            }
           //消息提示
             int message = 0;
             try{
                  //使用Apache文件上传组件处理文件上传步骤：
                  //1、创建一个DiskFileItemFactory工厂
                 DiskFileItemFactory factory = new DiskFileItemFactory();
                  //2、创建一个文件上传解析器
                  ServletFileUpload upload = new ServletFileUpload(factory);
                  //解决上传文件名的中文乱码
                  upload.setHeaderEncoding("UTF-8"); 
                  //3、判断提交上来的数据是否是上传表单的数据
                 
                  //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
                  List<FileItem> list = upload.parseRequest(request);
                 for(FileItem item : list){
                     //如果fileitem中封装的是普通输入项的数据
                    if(item.isFormField()){
                          String name = item.getFieldName();
                         //解决普通输入项的数据的中文乱码问题
                          String value = item.getString("UTF-8");
                          if(name.equals("name")){
                        	  if(value==null||value.equals("null")||value==""||value.equals("")){
                        		  out.print("<script>alert(\"请输入商品名称！\");location.href=\"HTshoppingsj.jsp\"</script>");
                        		  return;
                        	  }
                        	  name1=value;
                          }
                          if(name.equals("description")){
                        	  description=value;
                          }
                          if(name.equals("price")){
                        	  if(value==null||value.equals("null")||value==""||value.equals("")){
                        		  out.print("<script>alert(\"请输入商品价格！\");location.href=\"HTshoppingsj.jsp\"</script>");
                        		  return;
                        	  }
                        	  price=Float.parseFloat(value);                       	 
                          }
                          if(name.equals("stock")){
                            	  if(value==null||value.equals("null")||value==""||value.equals("")){
                            		  out.print("<script>alert(\"请输入商品库存数量！\");location.href=\"HTshoppingsj.jsp\"</script>");
                            		  return;
                            	  }
                        	  stock=Integer.parseInt(value);
                          }
                         
                          if(name.equals("fenlei1")){
                        	  if(value.equals("0")){
                        		  out.print("<script>alert(\"请选择一级分类！\");location.href=\"HTshoppingsj.jsp\"</script>");
                        		  return;
                        	  }
                        	  categoryLevel1Id=Integer.parseInt(value);
                          }
                          if(name.equals("fenlei2")){
                        	  if(value.equals("0")){
                        		  categoryLevel2Id=0;
                        	  }else{
                        	  categoryLevel2Id=Integer.parseInt(value);
                        	  }
                          }
                          if(name.equals("fenlei3")){
                        	  if(value.equals("0")){
                        		  categoryLevel3Id=0;
                        	  }else{
                        	  categoryLevel3Id=Integer.parseInt(value);
                        	  }
                          }
                          //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                         System.out.println(name + "=" + value);
                      }else{//如果fileitem中封装的是上传文件
                       //得到上传的文件名称，
                        String filename = item.getName();
                        fileName=filename;
                        if(fileName==null||fileName.equals("null")||fileName==""||fileName.equals("")){
             				out.print("<script>alert(\"请选择图片！\");location.href=\"HTshoppingsj.jsp\"</script>");
             				return;
             			}
                        //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                          //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                          //获取item中的上传文件的输入流
                          InputStream in = item.getInputStream();
                          //创建一个文件输出流
                          FileOutputStream out1 = new FileOutputStream(savePath + "\\" + filename);
                          //创建一个缓冲区
                          byte buffer[] = new byte[1024];
                          //判断输入流中的数据是否已经读完的标识
                          int len = 0;
                          //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                          while((len=in.read(buffer))>0){
                              //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        	  out1.write(buffer, 0, len);
                          }
                          //关闭输入流
                          in.close();
                          //关闭输出流
                          out1.close();
                          //删除处理文件上传时生成的临时文件
                          item.delete();
                          message = 1;
                      }
                  }
                    
                 }catch (Exception e) {
                  message= 0;
                  e.printStackTrace();                  
              }
             
			
			
			Product product=new Product(0, name1, description, price, stock, 
					categoryLevel1Id, categoryLevel2Id, categoryLevel3Id, fileName, 0);
			
			int sf=productService.listShopping(product);
			if(message==1&&sf>0){
				out.print("<script>alert(\"商品添加成功！\");location.href=\"ProductServlet?pro=spxx\"</script>");
			}else{
				out.print("<script>alert(\"商品添加失败！\");location.href=\"ProductServlet?pro=spxx\"</script>");
			}
	
		}else if(pro.equals("xiougaitianjia1")){
			
			int id=Integer.parseInt(request.getParameter("id"));
			Product product= productService.selByid(id);
			request.setAttribute("id", id);
			request.setAttribute("product", product);
			request.getRequestDispatcher("HTshoppingsj.jsp").forward(request, response);
		}else if(pro.equals("xiougaitianjia2")){
			int id=0;
			String name1="";
			String description="";
			float price=0;
			int stock=0;
			String fileName="";		
			int categoryLevel1Id=0;
			int categoryLevel2Id=0;
			int categoryLevel3Id=0;
			String savePath = this.getServletContext().getRealPath("/files");
            File file = new File(savePath);
              //判断上传文件的保存目录是否存在
             if (!file.exists() && !file.isDirectory()) {
                System.out.println(savePath+"目录不存在，需要创建");
                  //创建目录
             file.mkdir();
            }
           //消息提示
             int message = 0;
             try{
                  //使用Apache文件上传组件处理文件上传步骤：
                  //1、创建一个DiskFileItemFactory工厂
                 DiskFileItemFactory factory = new DiskFileItemFactory();
                  //2、创建一个文件上传解析器
                  ServletFileUpload upload = new ServletFileUpload(factory);
                  //解决上传文件名的中文乱码
                  upload.setHeaderEncoding("UTF-8"); 
                  //3、判断提交上来的数据是否是上传表单的数据
                 
                  //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
                  List<FileItem> list = upload.parseRequest(request);
                 for(FileItem item : list){
                     //如果fileitem中封装的是普通输入项的数据
                    if(item.isFormField()){
                          String name = item.getFieldName();
                         //解决普通输入项的数据的中文乱码问题
                          String value = item.getString("UTF-8");
                          if(name.equals("fileName1")){
                        	  if(value==null||value.equals("null")||value==""||value.equals("")){
                        	  
                        	  }else{
                        		  fileName=value;
                        	  }
                    	  
                      }
                          if(name.equals("shangpinid")){	 
                        		  id=Integer.parseInt(value);	  
                           }
                          if(name.equals("name")){
                        	  if(value==null||value.equals("null")||value==""||value.equals("")){
                        		  out.print("<script>alert(\"请输入商品名称！\");location.href=\"HTshoppingsj.jsp\"</script>");
                        		  return;
                        	  }
                        	  name1=value;
                          }
                          if(name.equals("description")){
                        	  description=value;
                          }
                          if(name.equals("price")){
                        	  if(value==null||value.equals("null")||value==""||value.equals("")){
                        		  out.print("<script>alert(\"请输入商品价格！\");location.href=\"HTshoppingsj.jsp\"</script>");
                        		  return;
                        	  }
                        	  price=Float.parseFloat(value);                        	 
                          }
                          if(name.equals("stock")){
                            	  if(value==null||value.equals("null")||value==""||value.equals("")){
                            		  out.print("<script>alert(\"请输入商品库存数量！\");location.href=\"HTshoppingsj.jsp\"</script>");
                            		  return;
                            	  }
                        	  stock=Integer.parseInt(value);
                          }
                         
                          if(name.equals("fenlei1")){
                        	  if(value.equals("0")){
                        		  out.print("<script>alert(\"请选择一级分类！\");location.href=\"HTshoppingsj.jsp\"</script>");
                        		  return;
                        	  }
                        	  categoryLevel1Id=Integer.parseInt(value);
                          }
                          if(name.equals("fenlei2")){
                        	  if(value.equals("0")){
                        		  categoryLevel2Id=0;
                        	  }else{
                        	  categoryLevel2Id=Integer.parseInt(value);
                        	  }
                          }
                          if(name.equals("fenlei3")){
                        	  if(value.equals("0")){
                        		  categoryLevel3Id=0;
                        	  }else{
                        	  categoryLevel3Id=Integer.parseInt(value);
                        	  }
                          }
                          //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                         System.out.println(name + "=" + value);
                      }else{//如果fileitem中封装的是上传文件
                       //得到上传的文件名称，
                        String filename = item.getName();
                       
                        if(fileName==null||fileName.equals("null")||fileName==""||fileName.equals("")){
             				continue;
             			}else{
             				 fileName=filename;
             			}
                        //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                          //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                          //获取item中的上传文件的输入流
                          InputStream in = item.getInputStream();
                          //创建一个文件输出流
                          FileOutputStream out1 = new FileOutputStream(savePath + "\\" + filename);
                          //创建一个缓冲区
                          byte buffer[] = new byte[1024];
                          //判断输入流中的数据是否已经读完的标识
                          int len = 0;
                          //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                          while((len=in.read(buffer))>0){
                              //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        	  out1.write(buffer, 0, len);
                          }
                          //关闭输入流
                          in.close();
                          //关闭输出流
                          out1.close();
                          //删除处理文件上传时生成的临时文件
                          item.delete();
                          message = 1;
                      }
                  }
                    
                 }catch (Exception e) {
                  message= 0;
                  e.printStackTrace();                  
              }
			Product product=new Product(id, name1, description, price, stock, 
					categoryLevel1Id, categoryLevel2Id, categoryLevel3Id, fileName, 0);
			
			int sf=productService.setShopping(product);
				out.print("<script>alert(\"商品修改成功！\");location.href=\"ProductServlet?pro=spxx\"</script>");
		}
		else if(pro.equals("fendel")){
		//删除分类
		int id=Integer.parseInt(request.getParameter("id"));
		List<ProductCategory> list=procate.selByParentId(id);
		int sf1=0;
		for (ProductCategory easybuyProductCategory : list) {
			sf1=easybuyProductCategory.getId();
			
		}
		if(sf1!=0){
			out.print("<script>alert(\"该分类下有子分类，不可删除！\");location.href=\"MemberUserServlet?action=common\"</script>");	
		}else{
			int sf=procate.deletef(id);
			if(sf>0){
				out.print("<script>alert(\"删除分类成功！\");location.href=\"MemberUserServlet?action=common\"</script>");
			}else{
				out.print("<script>alert(\"删除分类失败！\");location.href=\"MemberUserServlet?action=common\"</script>");
			}
		}
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
