package blatt26.aufgabe02;

public class Computer implements Comparable {
    private int speicher;
    private int ram;
    private double speedCpu;
    private double speedRam;
    private double speedDisk;
    private double speedGpu;
    private double speedVram;
    private int vram;

    public Computer(int speicher, int ram, double speedCpu, double speedRam, double speedDisk, double speedGpu, double speedVram, int vram) {
        this.speicher = speicher;
        this.ram = ram;
        this.speedCpu = speedCpu;
        this.speedRam = speedRam;
        this.speedDisk = speedDisk;
        this.speedGpu = speedGpu;
        this.speedVram = speedVram;
        this.vram = vram;
    }

    @Override
    public boolean compareTo(Computer computer) {
        int a = 0;
        int b = 0;
        if (this.speicher > computer.speicher) {
            a++;
        } else {
            b++;
        }
        if (this.ram < computer.ram) {
            a++;
        } else {
            b++;
        }
        if (this.speedCpu > computer.speedCpu) {
            a++;
        } else {
            b++;
        }
        if (this.speedRam > computer.speedRam) {
            a++;
        } else {
            b++;
        }
        if (this.speedDisk > computer.speedDisk) {
            a++;
        } else {
            b++;
        }
        if (this.speedGpu > computer.speedGpu) {
            a++;
        } else {
            b++;
        }
        if (this.speedVram > computer.speedVram) {
            a++;
        } else {
            b++;
        }
        if (this.vram > computer.vram) {
            a++;
        } else {
            b++;
        }
        if (a >= b) {
            return true;
        } else  {
            return false;
        }
    }

    public void ausgabe() {

    }
}
