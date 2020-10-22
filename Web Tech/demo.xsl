<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" version="1.0" encoding="UTF-8" indent="yes" />
    <xsl:template match="/">
        <html>
            <link rel="Stylesheet" type="text/css" href="mys.css" />
            <body>
                <div class="main">My Book Collection:</div><br/><br/>
                <center><table border="1">
                    <tr>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Year</th>
                        <th>Price</th>
                    </tr>
                    <xsl:for-each select="bookstore/book">
                        <tr>
                                <td>
                                    <xsl:value-of select="title"/>
                                    <br/>
                                    (<xsl:value-of select="@category" />)
                                </td>
                                <td>
                                    <xsl:value-of select="author"/>
                                </td>
                                <td>
                                    <xsl:value-of select="year"/>
                                </td>
                                <td>
                                    <xsl:value-of select="price"/>
                                </td>
                        </tr>
                    </xsl:for-each>
                    </table></center>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
