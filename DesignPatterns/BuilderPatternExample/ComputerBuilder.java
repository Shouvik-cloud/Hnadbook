package BuilderPatternExample;

public class ComputerBuilder {

    private String CPU;
    private String RAM;
    private String storage;

    public ComputerBuilder setCPU(String CPU) {
        this.CPU = CPU;
        return this;
    }

    public ComputerBuilder setRAM(String RAM) {
        this.RAM = RAM;
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public Computer build() {
        return new Computer(CPU, RAM, storage);
    }
}