package services;

public class MemoryDatabase implements Database{
    @Override
    public String getOne() {
        return this.toString();
    }
}
