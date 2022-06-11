<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper - Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <form method="post" action="note">
            <div>
                <label>Title: </label>
                <input type="text" name="edit_title" value="${note.title}">
            </div>
            
            <div>
                <label>Contents: </label>
                <textarea name="edit_content" rows="10" cols="40">${note.content}</textarea>
            </div>
            
            <div>
                <input type="submit" value="Save">
            </div>
        </form>
    </body>
</html>
