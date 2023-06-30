<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Converted Power Tools</title>
            </head>
            <body>
                <h1>Power Tools</h1>
                <table border="1">
                    <tr>
                        <th>Model</th>
                        <th>Handy</th>
                        <th>Origin</th>
                        <th>Energy Consumption</th>
                        <th>Performance</th>
                        <th>Autonomous</th>
                        <th>Material</th>
                    </tr>
                    <xsl:for-each select="PowerTools/Tool">
                        <tr>
                            <td><xsl:value-of select="Model"/></td>
                            <td><xsl:value-of select="Handy"/></td>
                            <td><xsl:value-of select="Origin"/></td>
                            <td><xsl:value-of select="TC/EnergyConsumption"/></td>
                            <td><xsl:value-of select="TC/Performance"/></td>
                            <td><xsl:value-of select="TC/Autonomous"/></td>
                            <td><xsl:value-of select="Material"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
