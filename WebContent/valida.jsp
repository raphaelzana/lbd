<%

session.setAttribute("email", request.getParameter("email"));
session.setAttribute("senhal", request.getParameter("senha"));

response.sendRedirect("");
%>
