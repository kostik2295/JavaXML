class TechnicalCharacteristic {
    private String energyConsumption;
    private int performance;
    private boolean autonomous;

    public TechnicalCharacteristic(String energyConsumption, int performance, boolean autonomous) {
        this.energyConsumption = energyConsumption;
        this.performance = performance;
        this.autonomous = autonomous;
    }

    public String getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(String energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public boolean isAutonomous() {
        return autonomous;
    }

    public void setAutonomous(boolean autonomous) {
        this.autonomous = autonomous;
    }

    @Override
    public String toString() {
        return "Energy Consumption: " + energyConsumption + ", Performance: " + performance + ", Autonomous: "
                + autonomous;
    }
}