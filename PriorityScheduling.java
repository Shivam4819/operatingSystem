/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operatingsystem;

/**
 *
 * @author shivam
 */
public class PriorityScheduling {
    public void findPriority(){
        int priority[]={2,4,6,10,8};
        int arrivalTime[]={0,0,1,2,3};
        int burstTime[]={4,2,3,5,1};
        int completionTime[]= new int[arrivalTime.length];
        int tat[]=new int[arrivalTime.length];
        int wt[]=new int[arrivalTime.length];
        
        int index=0,index2=0,max=0,j=0,flag=0;
        int k=1;
        //to find ct[0] if we have to process whose arrival time is same
        for(int i=1;i<arrivalTime.length;i++){
            if(arrivalTime[0]==arrivalTime[i]){
                flag=1;
                index=i;
            }
            
        }
        max=priority[0];
        if(flag==1){
            for(int i=0;i<=index;i++){
                if(priority[i]>max){
                    max=priority[i];
                    index2=i;
                }
            }
            completionTime[index2]=burstTime[index2];
            priority[index2]=-1;
            j=index2;
        }
        else if(flag==0){
            completionTime[0]= burstTime[0];
            priority[0]=-1;
        }
        index2=0;
        index=0;
        flag=0;
        
        
        
        while(k<priority.length){
            for(int i=0;i<arrivalTime.length;i++){
                if(arrivalTime[i]<=completionTime[j]){
                    index=i;
                }
            }
            max=priority[0];
            for(int i=0;i<=index;i++){
                if(priority[i]>max){
                    max=priority[i];
                    index2=i;
                    flag=1;
                }
                else if(flag==0){
                    index2=i;
                    System.out.println("wlcome ");
                    flag=1;
                }
                
                    
            }

            if(flag==1){
                completionTime[index2]=completionTime[j]+burstTime[index2];
                System.out.print("completion["+index2+"]-> "+completionTime[index2]);
                j=index2;
                priority[index2]=-1;
                //index2=1;
                flag=0;
                System.out.println("   max->"+max);
            }
            k++;
        }
        
        //tat= ct-at
        for(int i=0;i<tat.length;i++){
            tat[i]=completionTime[i]-arrivalTime[i];
        }
        
        
        //wt=tat-bt
        for(int i=0;i<wt.length;i++){
            wt[i]=tat[i]-burstTime[i];
        }
        
        
        
        for(int i=0;i<completionTime.length;i++){
            System.out.println(completionTime[i]);
        }
    }
}
