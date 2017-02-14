package com.tcs.ilp.Controller;



import java.awt.BorderLayout;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.tcs.ilp.util.DatabaseUtil;

/**
 * Servlet implementation class FileUploadDBServlet
 */
public class FileUploadDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String firstName = request.getParameter("firstName");
	        
	         
	        InputStream inputStream = null; // input stream of the upload file
	         Connection con = DatabaseUtil.getConnection();
	        // obtains the upload file part in this multipart request
	        String photo = request.getParameter("photo");
	        System.out.println(photo);
	     
	        photo = "C:\\Users\\833992\\Desktop\\MAS_TEAM5\\WebContent\\images\\" + photo;
	        
	        File file = new File(photo);
	        	PreparedStatement psmnt;
				try {
					psmnt = con.prepareStatement("insert into temp values(?,?)");
					psmnt.setString(1,firstName);
	        		        	
	        		FileInputStream fis = new FileInputStream(file);
	        		psmnt.setBinaryStream(2, (InputStream)fis, (int)(file.length()));
	        		int r = psmnt.executeUpdate();
	        		
	        		Image image = null;
	        	    try {
	        	    
	        	        // Read from an input stream
	        	        InputStream is = new BufferedInputStream(fis);
	        	        image = ImageIO.read(is);
	        	    
	        	        
	        	    } catch (IOException e) {
	        	    }
	        	

	        		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        		
	        		
	      
	}

}
