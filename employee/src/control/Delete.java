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

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));

		// データベースに接続するための情報
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "tibitaMaki1962@";
		String SQL = "DELETE FROM employees where id=?;";

		// データベースに接続する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection(url, user, password);
					PreparedStatement ps = con.prepareStatement(SQL);) {

				ps.setInt(1, id);
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
