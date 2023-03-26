package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean;

@WebServlet("/Select")
public class Select extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		// データベースに接続するための情報
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "tibitaMaki1962@";

		// アカウント名を格納するList
		List<Bean> beanList = new ArrayList<>();

		// データベースに接続する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection(url, user, password);
					Statement st = con.createStatement();) {

				// SQLを実行して、accountテーブルからアカウント名を取得する
				ResultSet res = st.executeQuery(
						"SELECT id,name,department FROM employees;");

				// 取得した件数分繰り返す
				while (res.next()) {

					Bean bean = new Bean();
					bean.setId(res.getInt("id"));
					bean.setName(res.getString("name"));
					bean.setDepartment(res.getString("department"));

					beanList.add(bean);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// リクエストスコープへオブジェクト設定する
		request.setAttribute("beanList", beanList);

		// 次の画面に遷移
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}