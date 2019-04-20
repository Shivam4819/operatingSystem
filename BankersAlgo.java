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
public class BankersAlgo {
    public void useBanker(){
        int r=3,p=5,finishedProcessCounter=0;
        int safeSequence[]=new int[p];
        int process[]={0,1,2,3,4};
        int finishedProcess[]=new int[p];
        int flag=0;
        int remaining[][]= new int[p][r];
        int count=0,k=0,safeSequencePoniter=0;
        
        int available[]={3,3,2};
        
        int allocated[][] = {{0, 1, 0}, 
                            {2, 0, 0}, 
                            {3, 0, 2}, 
                            {2, 1, 1}, 
                            {0, 0, 2}}; 
        
        int maxmimumNeed[][] = {{7, 5, 3}, 
                                {3, 2, 2}, 
                                {9, 0, 2}, 
                                {4, 2, 2}, 
                                {5, 3, 3}}; 
    
        
        
        for(int i=0;i<p;i++){
            finishedProcess[i]=-1;
        }
        
        for(int i=0;i<p;i++){
            for(int j=0;j<r;j++){
                remaining[i][j]=maxmimumNeed[i][j]-allocated[i][j];
            }
        }
        
        
        
        
        for(int i=0;i<p;i++){
            for(int j=0;j<r;j++){
                System.out.print(remaining[i][j]+" ");
            }
            System.out.println("");
        }
        
        
        
        
        while(k<safeSequence.length){
            for(int i=0;i<p;i++){
                if(remaining[i][0]!=-1){
                    for(int j=0;j<r;j++){
                        if(remaining[i][j]<=available[j])
                            count=1;
                        else
                            break;
                    }
                }
                
                if(count==1){
                    for(int j=0;j<r;j++){
                        available[j]=available[j]+remaining[i][j];
                        remaining[i][j]=-1;
                    }
                    safeSequence[safeSequencePoniter++]=i;
                    count=0;
                    finishedProcess[finishedProcessCounter++]=1;
                }
                
            }
            k++;
        }
        
        
        
        for(int i=0;i<p;i++){
            if(finishedProcess[i]==1)
                flag=1;
            else
                flag=0;
        }
        
        if(flag==1){
            System.out.println("system is safe");
            for(int i=0;i<p;i++){
                System.out.print(safeSequence[i]+" ");
            }
        }
        else{
            System.out.println("system is not safe");
        }

    }

}
