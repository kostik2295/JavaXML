<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <PowerTools>
            <xsl:for-each select="PowerTools/Tool">
                <Tool>
                    <Model>
                        <xsl:value-of select="Model"/>
                    </Model>
                    <Handy>
                        <xsl:value-of select="Handy"/>
                    </Handy>
                    <Origin>
                        <xsl:value-of select="Origin"/>
                    </Origin>
                    <TC>
                        <xsl:for-each select="TC">
                            <EnergyConsumption>
                                <xsl:value-of select="EnergyConsumption"/>
                            </EnergyConsumption>
                            <Performance>
                                <xsl:value-of select="Performance"/>
                            </Performance>
                            <Autonomous>
                                <xsl:value-of select="Autonomous"/>
                            </Autonomous>
                        </xsl:for-each>
                    </TC>
                    <Material>
                        <xsl:value-of select="Material"/>
                    </Material>
                </Tool>
            </xsl:for-each>
        </PowerTools>
    </xsl:template>
</xsl:stylesheet>
