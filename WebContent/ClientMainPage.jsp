<%@include file="header.jsp"%>

<html>
<head>

<h2>Client</h2>
</head>
<body>
	<form>
		<table>
			<tr><h3>
				<td><a href="Bug_DetailsInsert.jsp"><img src="Bugzilla Main Page_files/insert.png" width="128" height="128" ></a></td>
				
				<td><a href="Bug_DetailsListServlet"><img src="Bugzilla Main Page_files/list.png" width="128" height="128" ></a></td>
				<td><a href="Bug_SnapshotInsert.jsp"><img src="Bugzilla Main Page_files/snapshot.png" width="128" height="128" ></a></td>
                <td><a href="Bug_SnapshotsListServlet"><img src="Bugzilla Main Page_files/snapshots.png" width="128" height="128" ></a></td>
			</h3>
		
			<tr>
				<td>Insert Bug Details</td>
				<td>Bug Details List</td>
				<td>Bug Snapshot</td>
				<td>Snapshots List</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Quick Search:</td>
				<td><input type="text" name=searchbox></td>
				<td><input type="submit" name=Search></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@include file="footer.jsp"%>
