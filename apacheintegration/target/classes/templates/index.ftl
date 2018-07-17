<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
</head>

<body>
<h1>Welcome</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Error Message</th>
        <th>Result</th>
        <th>Test Case</th>

    </tr>
            <#list result as row>
            <tr>
                <td>${row.id}</td>
                <td><#if row.errorMessage??>${row.errorMessage}<#else></#if>
                <td>${row.success}</td>
                <td>${row.testCase}</td>
            </tr>
            </#list>
</table>
</body>

</html>