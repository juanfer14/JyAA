package servlets;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * Servlet implementation class GenerarPresupuesto
 */
public class GenerarPresupuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/myproject") //load resource file- context.xml
    private DataSource ds;  //Creating DataSource object
 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarPresupuesto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
		Connection con;
		Statement st;
		ResultSet rs;
		try {
			con = ds.getConnection();
			st = con.createStatement();
			rs =  st.executeQuery("select * from users");
			while(rs.next()) {
				System.out.println(rs.getString("name") + ", "+rs.getString("email"));
               
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
