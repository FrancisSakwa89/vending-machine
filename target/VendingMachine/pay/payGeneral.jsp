<html>
<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 9/16/19
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp" %>
<head>
    <title>Title</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script><html>

</head>
<body>
<br><br><br><br><br><br><br><br>
<%--<p style="text-align: center">Payment Options are.....</p>--%>
<%--<p style="text-align: center">Your total is: ${sale.total}</p>--%>
<form action="pay" method="post" style="margin-left: 35%;width:50%">
    <select name="pay" class="btn btn-success" aria-required="true">
        <option value="" disabled selected>Pay Option</option>
        <option name="name">NICKLE</option>
        <option name="name">DIME</option>
        <option name="name">QUARTER</option>
        <option name="name">PENNY</option>
        <option name="name">DOLLAR</option>

    </select>
    <br><br>
    <div class="group">
        <input type="number" required name="coinNumber">
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>How many coins?</label>
    </div>
    <button class="btn-cancel btn btn-success btn-sm" type="reset" value="">Submit</button>
    <button class="btn-cancel btn btn-danger btn-sm" type="reset" value="">Cancel</button>
</form>
<script>
    $(".dropdown-menu li a").click(function(){
        var selText = $(this).text();
        $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
    });
    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems, options);
    });

    // Or with jQuery

    $(document).ready(function(){
        $('select').formSelect();
    });

</script>
<style>
    <style>
    * { box-sizing:border-box; }

    /* basic stylings ------------------------------------------ */
    body 				 { background:url(https://scotch.io/wp-content/uploads/2014/07/61.jpg); }
    .container 		{
        font-family:'Roboto';
        width:600px;
        margin:30px auto 0;
        display:block;
        background:#FFF;
        padding:10px 50px 50px;
    }
    h2 		 {
        text-align:center;
        margin-bottom:50px;
    }
    h2 small {
        font-weight:normal;
        color:#888;
        display:block;
    }
    .footer 	{ text-align:center; }
    .footer a  { color:#53B2C8; }

    /* form starting stylings ------------------------------- */
    .group 			  {
        position:relative;
        margin-bottom:45px;
    }
    input 				{
        font-size:18px;
        padding:10px 10px 10px 5px;
        display:block;
        width:300px;
        border:none;
        border-bottom:1px solid #757575;
    }
    input:focus 		{ outline:none; }

    /* LABEL ======================================= */
    label 				 {
        color:#999;
        font-size:18px;
        font-weight:normal;
        position:absolute;
        pointer-events:none;
        left:5px;
        top:10px;
        transition:0.2s ease all;
        -moz-transition:0.2s ease all;
        -webkit-transition:0.2s ease all;
    }

    /* active state */
    input:focus ~ label, input:valid ~ label 		{
        top:-20px;
        font-size:14px;
        color:#5264AE;
    }

    /* BOTTOM BARS ================================= */
    .bar 	{ position:relative; display:block; width:300px; }
    .bar:before, .bar:after 	{
        content:'';
        height:2px;
        width:0;
        bottom:1px;
        position:absolute;
        background:#5264AE;
        transition:0.2s ease all;
        -moz-transition:0.2s ease all;
        -webkit-transition:0.2s ease all;
    }
    .bar:before {
        left:50%;
    }
    .bar:after {
        right:50%;
    }

    /* active state */
    input:focus ~ .bar:before, input:focus ~ .bar:after {
        width:50%;
    }

    /* HIGHLIGHTER ================================== */
    .highlight {
        position:absolute;
        height:60%;
        width:100px;
        top:25%;
        left:0;
        pointer-events:none;
        opacity:0.5;
    }

    /* active state */
    input:focus ~ .highlight {
        -webkit-animation:inputHighlighter 0.3s ease;
        -moz-animation:inputHighlighter 0.3s ease;
        animation:inputHighlighter 0.3s ease;
    }

    /* ANIMATIONS ================ */
    @-webkit-keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }
    @-moz-keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }
    @keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }

</style>
</style>

</body>
</html>
