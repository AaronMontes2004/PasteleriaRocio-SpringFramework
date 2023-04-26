<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pasteleria Rocio</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/CSS/factura.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Acme&family=Alfa+Slab+One&family=Cabin:ital@1&family=Grand+Hotel&family=Josefin+Sans:ital,wght@1,600&family=Lobster&family=Mochiy+Pop+One&family=Montserrat+Alternates&family=Nokora&family=Overpass&family=Pacifico&family=Potta+One&family=Preahvihear&family=Secular+One&family=Staatliches&family=Ubuntu&display=swap" rel="stylesheet">
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" valign="top" 
				style="background-image: url('https://media-cdn.tripadvisor.com/media/photo-s/1a/13/cd/d3/tambien-se-exhiben-una.jpg');background-repeat: no-repeat;background-size: cover;"><br> <br>
				<table width="600" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="center" valign="top" bgcolor="#d3be6c"
							style="	 background-color: bisque; padding: 0px 15px 10px 15px;">
							
							<div style="font-size: 20px; color:white; padding-top:10px">
								<h1 style=" font-size: 40pt; color: rgb(141, 86, 47); font-family: 'Potta One', cursive"><b>Pasteleria Rocio</b></h1>
							</div>
							<div style="color:white; text-align: left;font-size: 15px;">
								<p style="font-family: 'Preahvihear', sans-serif; font-size: 14pt; color: black;">RUC: <span style="color: blue;">10097400020</span></p>
								<p style="font-family: 'Preahvihear', sans-serif; font-size: 14pt; color:black;">NOMBRE Y APELLIDO: ${nombre}</p>
								<p style="font-family: 'Preahvihear', sans-serif;font-size: 14pt; color:black;">FECHA DE EMISION: ${fecha}</p>
							<p style="subtexto">PAGO: <span>Paypal</span></p>
							</div>
								
							<div style="font-size: 15px;width: 600px;">
								<table style="text-align: left; width: 100%; border-collapse: collapse;"> 
									<tr style="	 background-color: chocolate; color: black;">
										<th style="padding: 10px; border: 1px solid black;">Nombre</th>
										<th style="padding: 10px; border: 1px solid black;">Precio</th>
										<th style="padding: 10px; border: 1px solid black;">Cantidad</th>
										<th style="padding: 10px; border: 1px solid black;">Total</th>
									</tr>
									<#list lista as l>
										<tr style="background-color: white; color: black; font-family: 'Acme', sans-serif;">
											<td style="padding: 10px;border: 1px solid black;">${l.nombre}</td>
											<td style="padding: 10px;border: 1px solid black;">${l.precio}</td>
											<td style="padding: 10px;border: 1px solid black;">${l.cantidad}</td>
											<td style="padding: 10px;border: 1px solid black;">${l.total}</td>
										</tr>
									</#list>
									<tr>
										<td style="padding: 10px;" colspan="2"></td>	
										<th style="padding: 10px; border: 1px solid black; background-color: white;"><b>Subtotal:</b></th>	
										<td style="padding: 10px; border: 1px solid black; background-color: white;">${pedido.subtotal}</td>	
									</tr>
									<tr>
										<td style="padding: 10px; " colspan="2"></td>	
										<th style="padding: 10px; border: 1px solid black; background-color: white;"><b>IGV::</b></th>	
										<td style="padding: 10px; border: 1px solid black; background-color: white;">${pedido.igv}</td>	
									</tr>
									<tr>
										<td style="padding: 10px;" colspan="2"></td>	
										<th style="padding: 10px; border: 1px solid black; background-color: white;"><b>Total::</b></th>	
										<td style="padding: 10px; border: 1px solid black; background-color: white;">${pedido.total}</td>	
									</tr>
								</table>
							</div>
							<div>
								<br>
								<h2 style="	font-family: 'Potta One', cursive;font-size: 18pt;color: rgb(141, 86, 47);"><b>¡Gracias por tu compra y por elergirnos como tu mejor opcion!</b></h2>
								<p style="font-family: 'Preahvihear', sans-serif; font-size: 14pt; color:  black;">Nuestra tienda ofrece pasteles a la mejor calidad y precio </p> <br>
								<img src="https://user-media-prod-pageloot.s3.amazonaws.com/images/7250f8b4-e64-qr-code.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAQWAIZL7AH5YLESO3%2F20221213%2Feu-central-1%2Fs3%2Faws4_request&X-Amz-Date=20221213T022051Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Signature=2a3480555db1b6c946b72b2da734c7877df37e7d3741cd375f1db9f0e889e180" alt="Imagen no encontrada" width="300" height="300">
								<p><b><p class="font-family: 'Potta One', cursive; font-size: 12pt; color: chocolate;">${Name}</p><p style="font-family: 'Acme', sans-serif; font-size: 12pt; color: black;">${location}</p></b></p>
								<br>
							</div>
						</td>
					</tr>
				</table> <br> <br></td>
		</tr>
	</table>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</body>
</html>