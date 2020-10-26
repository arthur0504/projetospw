<%@page import="java.sql.*"%>
<%@page import="config.Conexao"%>
<%@page import="com.mysql.jdbc.Driver"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>               
        <%
            String usuarioSessao = (String) session.getAttribute("usuarioSessao");

            if (usuarioSessao == null) {
                response.sendRedirect("index.jsp");
            }
        %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">ETEC</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        
                    </li>                    
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <%
                        out.println("Olá " + usuarioSessao + " &nbsp;");
                    %>
                    <a href="logout.jsp"><input type="button" class="btn btn-outline-danger my-2 my-sm-0" value="SAIR" /></a>
                </form>
            </div>
        </nav>
        <div class="container">
        <div class="row mt-4 mb-4">
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            
            <button type="button" class="btn-info" data-toggle="modal" data-target="#modalInserir"> Inserir Novo Usuário </button>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" name="txtbuscar" placeholder="Digite um nome" aria-label="Search">
                <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Buscar</button>
            </form>
        </div>
        
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col">Senha</th>
                        <th scope="col">Nível</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Statement st = null;
                        ResultSet rs = null;
                        String id_usuario = "";
                        String nome_usuario = "";
                        String email_usuario = "";
                        String senha_usuario = "";
                        String nivel_usuario = "";

                        try {
                            st = new Conexao().conectar().createStatement();
                            rs = st.executeQuery("SELECT * FROM usuarios ");
                            while (rs.next()) {
                    %>
                    <tr>
                        <td><%= rs.getString(1)%></td>
                        <td><%= rs.getString(2)%></td>
                        <td><%= rs.getString(5)%></td>
                        <td><%= rs.getString(3)%></td>
                        <td><%= rs.getString(4)%></td>
                    </tr>
                    <%
                            }
                        } catch (Exception ex) {
                            out.println(ex);
                        }
                    %>                    
                </tbody>
            </table>
        </div>

    </body>
</html>

<!-- Modal -->
<div class="modal fade" id="modalInserir" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Inserir Usuários</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form id="login-form" class="form" action="" method="post">
            <div class="modal-body">
        
                            <h3 class="text-center text-info">Cadastro de Usuários</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Nome:</label><br>
                                <input type="text" name="nome" id="nome" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="username" class="text-info">Email:</label><br>
                                <input type="text" name="email" id="email" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Senha:</label><br>
                                <input type="password" name="senha" id="senha" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="username" class="text-info">Nível</label><br>
                                <select class="form-control" name="nivel" id="nivel">
                                    <option value="comum">Comum</option>
                                    <option value="admin">Administrador</option>
                                </select>
                            </div>
            </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
        <button type="submit" name="btn-salvar" class="btn btn-primary">Salvar</button>
      </div>
        </form>
    </div>
  </div>
</div>

<% 
    if (request.getParameter("btn-salvar") != null) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String nivel = request.getParameter("nivel");                                    
            
            try {
                st = new Conexao().conectar().createStatement();
                rs = st.executeQuery("SELECT * FROM usuarios WHERE email = '" + email + "'");
                while(rs.next()){                        
                    rs.getRow();
                    if (rs.getRow() > 0) {
                            out.println("Usuário ja cadastrado");
                            return;
                        }
                }  
                st.executeUpdate("INSERT INTO usuarios (nome, email, senha, nivel) " + " VALUES ('" + nome + "','" + email + "','" + senha + "','" + nivel + "')");
                response.sendRedirect("restrita.jsp");
            } catch (Exception e){
                out.println(e);
            }
            
        }
%>