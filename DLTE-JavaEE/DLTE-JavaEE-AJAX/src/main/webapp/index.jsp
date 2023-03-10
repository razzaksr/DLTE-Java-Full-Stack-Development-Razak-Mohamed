<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script>
        $(document).ready(()=>{
            $("h2").mouseenter(()=>{
                $.get("communicate",(casanova)=>{
                    alert(casanova);
                    $("p").text(casanova)
                })
            })

            $("form").submit((event)=>{
                //$(this).preventDefault();
                const banker=$("input[name=banker]").val();
                const mob=$("input[name=contact]").val();
                //alert(banker+" "+mob);
                $.post("formserv",{
                    "banker":banker,
                    "contact":mob
                },(data)=>{
                    $("p").text(data)
                })
                event.preventDefault();
                $("input[name=banker]").val("")
                $("input[name=contact]").val("")
            })
        })
    </script>
</head>
<body>
<h2>Hello World!</h2>
<p>Server data</p>

<form>
    <input type="text" name="banker" />
    <input type="text" name="contact" />
    <input type="submit">
</form>
</body>
</html>
