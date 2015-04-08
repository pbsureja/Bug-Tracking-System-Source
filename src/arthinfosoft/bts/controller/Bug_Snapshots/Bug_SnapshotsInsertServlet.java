package arthinfosoft.bts.controller.Bug_Snapshots;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arthinfosoft.bts.bean.Bug_SnapshotsBean;
import arthinfosoft.bts.dao.Bug_SnapshotsDAO;
import arthinfosoft.bts.util.ValidationUtils;
import java.io.File;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class Bug_SnapshotsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;
		Bug_SnapshotsBean bean=new Bug_SnapshotsBean();
		Boolean isError=false;
		

		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("bug_id")) {
						
						if(fieldValue.equals("")){
							request.setAttribute("bug_id",
									"<font color=red>Is Required Bug_id</font>");
							isError = true;
						}else{
							bean.setBug_id(Integer.parseInt(fieldValue));
						}
					}
				}else {
					fieldName = item.getFieldName();
					//System.out.println("FieldName : "+fieldName);
					fileName = item.getName();
//					System.out.println("File Name : "+fileName);
					
					fileName = fileName.substring(
							fileName.lastIndexOf("\\") + 1,
							fileName.length());
	//				System.out.println("File Name 1 : "+fileName);
					
					ServletContext context = getServletContext();
					String path = context.getRealPath(File.separator)+File.separator+"images";
		//			System.out.println("Path : "+path);
					File f=new File(path);
					if(!f.exists())
						f.mkdir();
					//String path = "D:\\New Folder\\FileUpload\\WebContent\\Upload";
					file = new File(path + File.separator
							+ fileName);

					try {

						if (fileName.isEmpty()) {

							request.setAttribute("snapshot_description",
									"<font color=red>It cannot be Empty</font>");
							isError = true;
						}
						else if(fileName.length()>30){
							request.setAttribute("snapshot_description",
									"<font color=red>File Name Too Large</font>");
							isError = true;
						}
						
						else {

							if (context.getMimeType(fileName).equals(
									"image/gif")
									|| context.getMimeType(fileName)
											.equals("image/jpeg")
									|| context.getMimeType(fileName)
											.equals("image/png")) {
								item.write(file);
								bean.setSnapshot_description(file.getName());
							} else {

								request.setAttribute(
										"snapshot_description",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
							isError=true;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	if(isError){
		
request.setAttribute("bean",bean);		
		request.getRequestDispatcher("Bug_SnapshotInsert.jsp").forward(request, response);
		
	}else{
	Boolean flag=new Bug_SnapshotsDAO().insertBug_Snapshots(bean);
	if(flag){
		response.sendRedirect("Bug_SnapshotsListServlet");
		System.out.println("Data Inserted");
	}else{
		response.sendRedirect("Bug_SnapshotsListServlet");
		System.out.println("Data Not Inserted");
		
		
	}
	
	}

}
}