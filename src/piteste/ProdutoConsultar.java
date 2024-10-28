package piteste;

import banco.BD;
import java.sql.SQLException;

public class ProdutoConsultar {
	public static void main(String[] args) {
		
		BD bd = new BD();
		
		if(bd.getConnection()) {
			String sql = "select * from produtos";
			try {
				bd.st = bd.con.prepareStatement(sql);//Toda vez que for usar instrução SQL usa isso
				bd.rs = bd.st.executeQuery(); //mas o ponteiro está a uma posição anterior ao primeiro registro
				while(bd.rs.next()){//ele avança um NEXT RETORNA VERDADEIRO OU FALSO
					System.out.println(bd.rs.getInt("id")+","+
							bd.rs.getString("nome")+","+
							bd.rs.getDouble("preco")+","+
							bd.rs.getInt("estoque"));
				}
//				bd.rs.next();//ele avança um 
//				System.out.println(bd.rs.getInt(1)); //pode por o nome ou o numero da coluna
//				System.out.println(bd.rs.getString(2));
//				System.out.println(bd.rs.getDouble(3));
//				System.out.println(bd.rs.getInt(4));	
				
				System.out.println("---------------------------------");
				
				sql = "select sum(preco) as total from produtos";
				bd.st = bd.con.prepareStatement(sql);
				bd.rs = bd.st.executeQuery();
				bd.rs.next();
				System.out.print("O total de produtos em estoque: ");
				System.out.println(bd.rs.getDouble("total")); //ou 1, pois é uma coluna só
				
				System.out.println("---------------------------------");
				
				sql = "select max(estoque) as maior_estoque from produtos";
				bd.st = bd.con.prepareStatement(sql);
				bd.rs = bd.st.executeQuery();
				bd.rs.next();
				System.out.println(bd.rs.getDouble("maior_estoque")); //ou 1, pois é uma coluna só
				
				System.out.println("---------------------------------");
				
				sql = "SELECT * FROM produtos ORDER BY estoque DESC;";
				bd.st = bd.con.prepareStatement(sql);
				bd.rs = bd.st.executeQuery();
				//bd.rs.next();
				
				while(bd.rs.next()){//ele avança um NEXT RETORNA VERDADEIRO OU FALSO
					System.out.println(bd.rs.getInt("id")+","+
							bd.rs.getString("nome")+","+
							bd.rs.getDouble("preco")+","+
							bd.rs.getInt("estoque"));
				}
			} 
			catch (SQLException erro) {
				System.out.println(erro);
			} 
			finally {
				bd.close(); //fecha a conexão
			}
		}
		else {
			System.out.println("Falha ao conectar");
		}
	}
}
