<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html dir="rtl">
			<head>
				<link type="text/css" rel="stylesheet" href="stylesheets/style.css" />
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
									<xsl:if test="hizb">
       									 <span class="num-hizb"><xsl:value-of select="./hizb/@index" /></span>
       									 <hr/>
   									</xsl:if>
   									<xsl:if test="nisf">
       									 <span class="num-nisf"><xsl:value-of select="./nisf/@index" /></span>
       									 <hr/>
   									</xsl:if>
   									<xsl:if test="rubu">
       									 <span class="num-rubu"><xsl:value-of select="./rubu/@index" /></span>
       									 <hr/>
   									</xsl:if>
   									<xsl:if test="tomon">
       									 <span class="num-tomon">
       									 	<xsl:value-of select="./tomon/@index" />
       									 </span>
       									 <hr/>
   									</xsl:if>	
									<xsl:if test="@bismillah">
       									 <span class="basmala"><xsl:value-of select="./@bismillah" /></span>
       									 <span class="num-verset">0</span>
   									</xsl:if>
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
