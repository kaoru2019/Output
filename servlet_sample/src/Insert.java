import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		// データベースのURL
		final String URL = "jdbc:mysql://localhost:3306/board";
		// データベースにアクセスするユーザー名
		final String USER = "root";
		// パスワード
		final String PASSWORD = "tibitaMaki1962@";

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
		System.out.println(sdf);
		String time = sdf.format(date);

		String name = request.getParameter("name");
		String comment = request.getParameter("comment");

		StringBuffer sb = new StringBuffer();

		PrintWriter out = response.getWriter();

		try {
			// ここでドライバの読み込みを行う
			Class.forName("com.mysql.jdbc.Driver");
			// ここでデータベースへ接続する
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "insert into account(time,name,comment) values(?,?,?);";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, time);
			stmt.setString(2, name);
			stmt.setString(3, comment);

			stmt.executeUpdate();

			con.close();

			sql = "SELECT * FROM account;";

			Connection con2 = DriverManager.getConnection(URL, USER, PASSWORD);

			stmt = con2.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			sb.append("<html>");
			sb.append("<head>");
			sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=0.5, user-scalable=yes\">");
			sb.append("<title>前の画面で選択した項目を削除しました</title>");
			sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"Insert_style.css\">");
			sb.append("</head>");
			sb.append("<body>");
			sb.append("<p>データを追加した後の結果は以下の通りです</p>");
			sb.append("<table>");
			sb.append("<tr>");
			sb.append("<th>日時</th><th>ID</th><th>名前</th><th>コメント</th>");
			sb.append("</tr>");
			while (rs.next()) {
				time = rs.getString("time");
				int id = rs.getInt("id");
				name = rs.getString("name");
				comment = rs.getString("comment");
				sb.append("<tr>");
				sb.append("<td>" + time + "</td><td>" + id + "</td><td>" + name + "</td><td>" + comment + "</td>");
				sb.append("</tr>");
			}
			sb.append("</table>");

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
