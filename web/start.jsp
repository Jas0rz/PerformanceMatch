<%-- 
    Document   : resultsPage
    Created on : 27-May-2013, 12:53:22 AM
    Author     : Chris Wallace <chris at devocean.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="${facesContext.externalContext.requestContextPath}/style.css" rel="stylesheet" type="text/css"/>
  		<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>
			<script>
				$(function() {
					$("#component span.info[title]").tooltip({
						// place tooltip on the right edge
						position: "center right",
						// a little tweaking of the position
						offset: [-12, 10],
						// use the built-in fadeIn/fadeOut effect
						effect: "fade",
						// custom opacity setting
						opacity: 0.7
					});

					//Toggle additional component details.
					$("span.expand").click(function() {
						var currentElement = $(this).parent().children("p.expandable");
						$(currentElement).slideToggle("fast");
					});

				});
			</script>
            <title>Overview</title>
        </head>
        <body>
            <div id="header-wrapper">Build a Machine</div>
            <div id="menu-wrapper"></div>
            <div id="upperBlock-wrapper"></div>
            <div id="pageBody-wrapper">
				<div id="component">
					<h4>What would you like to do?</h4>
				<h:selectOneListbox value="#{Customer.selectedGame}">
					<f:selectItem itemValue="#{Customer.allGames[0]}" itemLabel="1" />
					<f:selectItem itemValue="#{Customer.allGames[1]}" itemLabel="2" />
					<f:selectItem itemValue="#{Customer.allGames[2]}" itemLabel="3" />
					<f:selectItem itemValue="#{Customer.allGames[3]}" itemLabel="4" />
				</h:selectOneListbox>
					&nbsp;
				<h:commandButton value="Submit" action="results"></h:commandButton>
				</div>
			</div>
            <div id="footer-wrapper"></div>
        </body>
    </html>
</f:view>
