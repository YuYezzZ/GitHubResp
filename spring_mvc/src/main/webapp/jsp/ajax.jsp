<%--
  Created by IntelliJ IDEA.
  User: Mr.Wu
  Date: 2022/1/5
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <script src="${pageContext.request.contextPath}/js/axios-0.18.0.js"></script>
</head>
<body>
<div id="app">
    <h1 >{{user.username}}请登录！</h1>
    <h1 >{{user.age}}请登录！</h1>

    <form   method="post" target="_blank">
        <table>
            <tr>
                <td>账号：</td>
                <td><input type="text" name="username" v-model:value="user.username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="password" v-model:value="user.age"></td>
            </tr>
            <tr>
                <td rowspan="2"><input type="submit" value="submit" onclick="submit"></td>
            </tr>
        </table>
    </form>
</div>
<script>
    new Vue({
        el:"app",
        methods:{
            submit(){
                let _this = this;
                axios({
                    method:"get",
                    url:"/user/quick12"
                }).then(function(resp){
                    _this.resp=resp.data()
                })
            }
        },
        data(){
            return{
                user:{
                    username:'',
                    age:''
                },
                resp:'',
            }
        },
    })
</script>
</body>
</html>
