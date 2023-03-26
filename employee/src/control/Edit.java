package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String department = request.getParameter("department");

		// データベースに接続するための情報
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "tibitaMaki1962@";
		String SQL = "UPDATE employees set name=?,age=?,gender=?,address=?,department=? where id=?;";

		// データベースに接続する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection(url, user, password);
					PreparedStatement ps = con.prepareStatement(SQL);) {

				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, gender);
				ps.setString(4, address);
				ps.setString(5, department);
				ps.setInt(6, id);
				ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Select").forward(request, response);

	}

}
