package arthinfosoft.bts.controller.Bug_Snapshots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arthinfosoft.bts.bean.Bug_SnapshotsBean;
import arthinfosoft.bts.dao.Bug_SnapshotsDAO;



public class Bug_SnapshotsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int snapshot_id=Integer.parseInt(request.getParameter("tid"));
		Bug_SnapshotsDAO dao=new Bug_SnapshotsDAO();
				Bug_SnapshotsBean bean=new Bug_SnapshotsBean();
				bean=dao.editData(snapshot_id);
				ServletContext context = getServletContext();
				String path = context.getRealPath(File.separator)+File.separator+"images"+File.separator;
//System.out.println(path+bean.getSnapshot_description());
				File f=new File(path+bean.getSnapshot_description());
				File ftemp=new File(path+"temp.jpg");
Boolean flag1=false;

// Making a temporary file as back up.
try{
FileInputStream fis=new FileInputStream(f);
FileOutputStream fos=new FileOutputStream(ftemp);
byte[] b=new byte[1024];
int length;
while((length=fis.read(b))>0){
	fos.write(b,0,length);
}
fis.close();
fos.close();
}catch(Exception e){
	e.printStackTrace();

}

try{
	if(f.exists()){
if(f.delete()){
					if(dao.deleteData(snapshot_id)){
				//	System.out.println("deleted flag true");
					response.sendRedirect("Bug_SnapshotsListServlet");
				}else{
					ftemp.renameTo(f);
//					System.out.println("deleted flag false");
					request.getRequestDispatcher("Bug_SnapshotsListServlet").forward(request, response);
				}
				}
}else{
	response.sendRedirect("Bug_SnapshotsListServlet");
}}
	catch(Exception e){
		e.printStackTrace();
		}
	}}


