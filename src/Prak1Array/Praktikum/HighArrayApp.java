/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prak1Array.Praktikum;

/**
 *
 * @author Ibrohim Aqimuddin
 */
class HighArray {
    private int[] arr;//deklarasi array
    private int nElemen;//deklarasi var nElemen
    
    public HighArray(int max){//constructor with maximum cell parameter of array & initialize nElemen
        arr = new int[max];
        nElemen = 0;
    }
    
    public void insert(int value){//insert method to input array value
        
        arr[nElemen] = value;
        nElemen++;
    }
    public void bubbleSort(){
        int lastIndex = nElemen-1;
        for(int i = 0 ; i < lastIndex ; i++){
            for(int j = 0 ; j < lastIndex-i ; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
    }
    public boolean find(int key){//find method to search array value
        int i;
        for(i=0; i<nElemen;i++){
            if(arr[i] == key){
                break;
            }
        }
        if(i == nElemen){
            return false;
        } else {
            return true;
        }
    }
    public int binarySearch(int key, int lowerIndex, int endIndex){
        int mid = (lowerIndex + endIndex - 1)/2;
        
        if(nElemen>lowerIndex){
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                return binarySearch(key, lowerIndex, mid);
            }else
                return binarySearch(key, mid, endIndex);
        }
        return -1;
    }
    public boolean delete(int value){//delete method to delete selected value inside array
        int i;
        for (i = 0; i<nElemen; i++){
            if (value == arr[i]){
                break;
            }
        }
        if(i== nElemen){
            return false;
        } else {
            for(int j = i;j<nElemen;j++){
                arr[j] = arr[j+1];
            }
            nElemen--;
            return true;
        }
        
    }
    public void display(){//display method to display every element of array
        bubbleSort();
        for(int i = 0; i< nElemen; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public void getSize(){//getSize method to show number of element in array
        int size = nElemen;
        System.out.println("Jumlah elemen pada array :"+size);
    }
}
public class HighArrayApp {
    public static void main(String[] args){
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);
        
        arr.insert(70);
        arr.insert(80);
        arr.insert(75);
        arr.insert(55);
        arr.insert(85);
        arr.insert(25);
        arr.insert(30);
        arr.insert(00);
        arr.insert(90);
        arr.insert(40);
        
        arr.display();
        /*int key = 25;
        if(arr.find(key)){
            System.out.print(key + "ditemukan");
        }else {
            System.out.print(key + "tidak ditemukan");
        }
        
        arr.delete(00);
        arr.delete(80);
        arr.delete(55);
        
        arr.display();*/
        arr.getSize();
        System.out.println("30 berada di index ke = "+arr.binarySearch(30, 0,10));
    }
}
