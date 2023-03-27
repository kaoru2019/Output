package control;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Image")
@MultipartConfig
public class Image extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		Part part = request.getPart("image");

		// データベースに接続するための情報
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "tibitaMaki1962@";
		String SQL = "UPDATE employees set image=? where id=?;";

		//ファイル名を取得
		String image = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//書き込み
		String URL = "C:\\pleiades\\workspace_servlet\\employee\\WebContent\\upload\\" + image;
		part.write(URL);

		// データベースに接続する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection(url, user, password);
					PreparedStatement ps = con.prepareStatement(SQL);) {

				ps.setString(1, image);
				ps.setInt(2, id);
				ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("Select");

	}

}
