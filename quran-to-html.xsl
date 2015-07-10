<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html dir="rtl">
			<head>
				<link type="text/css" rel="stylesheet" href="css/style.css" />
			</head>
			<body>
				<xsl:for-each select="quran/sura">
					<article class="surat">
						<div class="titre">
							<xsl:value-of select="./@name" />
							<span class="num-surat"><xsl:value-of select="./@index" /></span>
						</div>

						<div class="versets">
							<xsl:for-each select="./aya">
									<span class="verset"><xsl:value-of select="./@text" /></span>
									<span class="num-verset"><xsl:value-of select="./@index" /></span>
						  </xsl:for-each>
						</div>
					</article>
			  </xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
