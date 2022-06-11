<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Siple Note Keeper - View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        
        <div>
            <b>Title: </b> ${note.title}
        </div>
        
        <div>
            <b>Contents: </b>
            <div>
                ${note.content}
            </div>
        </div>
            
        <br>
        
        <div>
            <a href="note?edit">Edit</a>
        </div>
    </body>
</html>
