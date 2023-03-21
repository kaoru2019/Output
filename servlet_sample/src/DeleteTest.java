import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteTest")
public class DeleteTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		final String URL = "jdbc:mysql://localhost:3306/board";
		final String USER = "root";
		final String PASSWORD = "●●●●";

		String name = request.getParameter("name");

		StringBuffer sb = new StringBuffer();

		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "DELETE FROM account WHERE name=?;";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, name);

			stmt.executeUpdate();

			con.close();

			sql = "select * from account;";

			Connection con2 = DriverManager.getConnection(URL, USER, PASSWORD);

			stmt = con2.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			sb.append("<html>");
			sb.append("<head>");
			sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=0.5, user-scalable=yes\">");
			sb.append("<title>前の画面で選択した項目を削除しました</title>");
			sb.append("</head>");
			sb.append("<body>");

			sb.append("<p>" + name + "を消しました。</p>");

			while (rs.next()) {

				String time = rs.getString("time");
				int id = rs.getInt("id");
				name = rs.getString("name");
				String comment = rs.getString("comment");
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<th>" + time + "</th>" + "<th>" + "【" + id + "】" + "</th>" + "<th>" + "名前:" + name + "</th>"
						+ "<th>"
						+ ">" + comment
						+ "</th>");
				sb.append("</tr>");
				sb.append("</table>");
			}

			out.println("<a href=\"Select\" >最初に戻る</a>");

			out.println(new String(sb));
			out.close();
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sb.append("</body>");
		sb.append("</html>");
	}
}
