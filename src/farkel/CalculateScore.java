package farkel;

import java.util.Scanner;

public class CalculateScore {
    
    private static int pwr(int power, int base) 
    {
	int ret=1; 
	while (power>0) {
		ret*=base;
		power--;
	} 
	return(ret);
    }
    
    public static int[] calculateScore(int[] roll){
        int[] rollToSend = {0,0,0,0,0,0};
        int i = 0;
        for(int x:roll){
            rollToSend[i] = x;
            i++;
        }
         
        rollToSend = main(rollToSend);
        return rollToSend;
        
    }
    
    public static int[] main(int[] roll){
        /*int roll[] = {0,0,0,0,0,0};
        Scanner userInput = new Scanner(System.in);
        roll[0] = Integer.parseInt(userInput.next());
        roll[1] = Integer.parseInt(userInput.next());
        roll[2] = Integer.parseInt(userInput.next());
        roll[3] = Integer.parseInt(userInput.next());
        roll[4] = Integer.parseInt(userInput.next());
        roll[5] = Integer.parseInt(userInput.next());*/
        
        int score=0,pt=0;
        int dice[]={0,0,0,0,0,0}; //score is the player's score, pt tracks wether they are scoring dies (for farkleing)
        int a=roll[0],b=roll[1],c=roll[2],d=roll[3],e=roll[4],f=roll[5];
        
        if ((a*a*a)==(b*b*c)||(a*a*a)==(b*b*d)||(a*a*a)==(b*b*e)||(a*a*a)==(b*b*f)||(a*a*a)==(c*c*d)||(a*a*a)==(c*c*e)||(a*a*a)==(c*c*f)||(a*a*a)==(d*d*e)||(a*a*a)==(d*d*f)||(a*a*a)==(e*e*f)) 
            pt++;
        else 
        {
            if (a==1) {
		score+=100;
		pt++;
            }
            else if (a==5) {
		score+=50;
		pt++;
            }
            else
		dice[0]++;
            
            roll[0]=0;
        }
        
        if ((b*b*b)==(a*a*c)||(b*b*b)==(a*a*d)||(b*b*b)==(a*a*e)||(b*b*b)==(a*a*f)||(b*b*b)==(c*c*d)||(b*b*b)==(c*c*e)||(b*b*b)==(c*c*f)||(b*b*b)==(d*d*e)||(b*b*b)==(d*d*f)||(b*b*b)==(e*e*f))
	pt++;
        
        else 
        {
            if (b==1) 
            {
		score+=100;
		pt++;
            }
            else if (b==5) 
            {
		score+=50;
		pt++;
            }
            else
		dice[1]++;
            
        roll[1]=0;
        }
        
        if ((c*c*c)==(b*b*a)||(c*c*c)==(b*b*d)||(c*c*c)==(b*b*e)||(c*c*c)==(b*b*f)||(c*c*c)==(a*a*d)||(c*c*c)==(a*a*e)||(c*c*c)==(a*a*f)||(c*c*c)==(d*d*e)||(c*c*c)==(d*d*f)||(c*c*c)==(e*e*f)) 
            pt++;
        else 
        {
            if (c==1) 
            {
		score+=100;
		pt++;
            }
            else if (c==5)
            {
		score+=50;
		pt++;
            }
            else
		dice[2]++;
            
        roll[2]=0;
    }
        
        if ((d*d*d)==(b*b*c)||(d*d*d)==(b*b*a)||(d*d*d)==(b*b*e)||(d*d*d)==(b*b*f)||(d*d*d)==(c*c*a)||(d*d*d)==(c*c*e)||(d*d*d)==(c*c*f)||(d*d*d)==(a*a*e)||(d*d*d)==(a*a*f)||(d*d*d)==(e*e*f)) 
	pt++;
        
        else
        {
            if (d==1) 
            {
		score+=100;
		pt++;
            }
            else if (d==5) 
            {
		score+=50;
		pt++;
            }
            else
		dice[3]++;
        roll[3]=0;
        }
        
    if ((e*e*e)==(b*b*c)||(e*e*e)==(b*b*d)||(e*e*e)==(b*b*a)||(e*e*e)==(b*b*f)||(e*e*e)==(c*c*d)||(e*e*e)==(c*c*a)||(e*e*e)==(c*c*f)||(e*e*e)==(d*d*a)||(e*e*e)==(d*d*f)||(e*e*e)==(a*a*f)) 
    {
	pt++;
    }
    else
    {
	if (e==1) 
	{
		score+=100;
		pt++;
	}
	else if (e==5) 
	{
		score+=50;
		pt++;
	}
	else
	{
		dice[4]++;
	}
    roll[4]=0;
    }
	
    if ((f*f*f)==(b*b*c)||(f*f*f)==(b*b*d)||(f*f*f)==(b*b*e)||(f*f*f)==(b*b*a)||(f*f*f)==(c*c*d)||(f*f*f)==(c*c*e)||(f*f*f)==(c*c*a)||(f*f*f)==(d*d*e)||(f*f*f)==(d*d*a)||(f*f*f)==(e*e*a)) 
	pt++;
    
    else
    {
	if (f==1) {
		score+=100;pt++;
        }
	else if (f==5) {
		score+=50;
                pt++;
        }
	else
		dice[5]++;
        
    roll[5]=0;
    }
    
    int count=0,rnum=0,scount=0; //count is just a loop counter, rnum controls the array value being called. scount tracks number of successful array calls
    int combo[]={0,0,0,0,0,0};
    int Sum=roll[0]+roll[1]+roll[2]+roll[3]+roll[4]+roll[5];
    
    while(count!=6){
	if (roll[rnum]!=0){
		combo[rnum]=roll[rnum];
		scount++;
	}
	else
            combo[rnum]=0;
	count++;
	rnum++;
    }
    
    int sum=combo[0]+combo[1]+combo[2]+combo[3]+combo[4]+combo[5],ssum=combo[0]+combo[1]+combo[2]+combo[3]+combo[4],lcount=0,avcount=0;rnum=0;
    while (lcount!=5){
	if (combo[rnum]!=0)
		avcount++;
	lcount++;
	rnum++;
    }
    
    float bgaverage=(float) ssum/avcount, average=(float) sum/scount; //average is just average, bgaverage is to check against average to prevent accedental averages
    if (average==1) 
	score+=1000*pwr(scount-3,2);
    else if ((average==2||average==3||average==4||average==5||average==6) & (scount>=3) & (average==bgaverage))
	score+=(int) average*100*pwr(scount-3,2);
    else if ((average<6) & (average>1)) {
	int first=combo[0];
        int second = 0;
        int x=1; //values of the two triples, and a loop counter
	while (x<=3) {
		if (combo[0]!=combo[x]){
			second=combo[x];
			x=4;
		}
		else x++;
	}
        
	if (first==1) 
            score+=1000;
	else 
            score+=first*100;

	if (second==1) 
            score+=1000;
	else 
            score+=second*100;
    }
    
    if (pt==0) 
    {
	score=0;
    }
    System.out.println(score);
    
    int returnStuff[] = {score, dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]}; 
    return returnStuff;
    }
}