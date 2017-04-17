package com.savitsky.blinovBook.chapter_04.variant_A;

/**
 * Created by esavitski on 17.04.2017.
 */
public class Computer {
    private enum State_on_off{
        TURN_ON, TURN_OFF;


        @Override
        public String toString() {
            return "On/Off{" +
                    "state=" + super.toString() +
                    '}';
        }
    }

    private Winchester winchester;
    private Drive drive;
    private RAM ram;
    private Processor processor;

    private State_on_off stateOnOff = State_on_off.TURN_OFF;

    public Computer(Object...accessories){
        for (Object accessory :
             accessories) {
            if(accessory instanceof Winchester){
                this.winchester = (Winchester) accessory;
                continue;
            }
            else if(accessory instanceof Drive){
                this.drive = (Drive) accessory;
                continue;
            }
            else if(accessory instanceof RAM){
                this.ram = (RAM) accessory;
                continue;
            }
            else if(accessory instanceof Processor){
                this.processor = (Processor) accessory;
                continue;
            }
            else{
                continue;
            }
        }
    }

    public void Turn_On(){
        stateOnOff = State_on_off.TURN_ON;
    }

    public void show_computer_info(){
        System.out.println(String.format("%s\n%s\n%s\n%s\n%s",
                stateOnOff, winchester, drive, ram, processor));
    }

   /* @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        Computer computer = (Computer) obj;
        if(!this.winchester.equals(computer.winchester))
            return false;
        if(!this.drive.equals(computer.drive))
            return false;
        if(!this.ram.equals(computer.ram))
            return false;
        if(!this.processor.equals(computer.processor))
            return false;

        return true;
    }*/

    /*@Override
    public int hashCode() {
        return (31 + winchester.getStorage_size() +
                17 + (drive.getName()!=null ? drive.getName().hashCode() : 0) +
                13 + ram.getStorage_size() +
                11 + (processor.getName()!=null ? processor.getName().hashCode() : 0));
    }*/
}
