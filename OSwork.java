import javax.swing.*;
import java.util.Scanner;

public class OSwork {

  public static int[] all= new int[10];
    public static int[] max= new int[10];
    public  static  int[] need= new int[10];
    public  static int flag =0;



    public static int fl;
    public static int i, j, k, p, b, n, r, g, cnt=0, id, newr;

    public static  int[] avail= new int[10];
    public static   int[] seq= new int[10];

    public void  file()
    {


    };
    //MFT class
    public static Scanner input = new Scanner(System.in);
    public static void MFT(){

        //MFT variables
        int availableMemorySize =0, blockSize=0, noBlocks, externalFragmentation,noOfProcess=0, totInternalFragmentation=0;
        boolean flag = true;
        String availableMemorySizeS=null,blockSizeS=null,noOfProcessS=null,processSizeS=null;
        int[] processSize =new int[10];
        int i,processInMem=0;
        int Array_Size =10;
        //Scanner input
        Scanner input = new Scanner(System.in);
        /*
        //display the output below
        do {
            System.out.println("Enter the total memory available (in Bytes) -- ");
            //accepting availableMemorySize input
            try {
                processSizeS = input.nextLine();
                availableMemorySize = Integer.parseInt(processSizeS);
                if(availableMemorySize>0){
                    flag=false;
                }
            }catch(Exception e){
                System.out.println("invalid input \n Try again");
            }
        }while(flag);
        flag=true;
        */
        System.out.println("Enter the total memory available (in Bytes) -- ");
        availableMemorySize=input_validator();
        System.out.println(availableMemorySize);
        //display the output below
        /*

        do {
            System.out.println("Enter the block size (in Bytes) -- ");
            //accepting availableMemorySize input
            try {
                blockSizeS = input.nextLine();
                blockSize = Integer.parseInt(blockSizeS);
                if(blockSize>0){
                    flag=false;
                }
            }catch(Exception e){
                System.out.println("invalid input \n Try again");
            }
        }while(flag);
        flag=true;
        */
        System.out.println("Enter the block size (in Bytes) -- ");
        blockSize=input_validator();

        //Acception input for number of blocks
        noBlocks=availableMemorySize/blockSize;

        //externalFragmentation
        externalFragmentation=availableMemorySize - noBlocks*blockSize;

        //display the output below

        /*
        do {
            System.out.println("\nEnter the number of processes -- ");
            //accepting availableMemorySize input
            try {
                noOfProcessS = input.nextLine();
                noOfProcess = Integer.parseInt(noOfProcessS);
                if(blockSize>0){
                    flag=false;
                }
            }catch(Exception e){
                System.out.println("invalid input \n Try again");
            }
        }while(flag);
        flag=true;
        */
        System.out.println("\nEnter the number of processes -- ");
        noOfProcess=input_validator();
        //input for number of processes in memory
        // noOfProcess= input.nextInt();
        /*
        //loop for process input
        int in=0;
        while(in<noOfProcess)
        {   // Display the output below
            System.out.println("Enter memory required for process"+(in+1)+"  (in Bytes)-- ");
            try{
                processSizeS= input.nextLine();
                int processSizeI =0;
                processSizeI=Integer.parseInt(processSizeS);
                processSize[in]=Integer.parseInt(processSizeS);
                if(processSizeI<=0){
                    in--;
                }else{
                    in++;
                }

            }catch (Exception e){
                System.out.println("invalid entry \n retry");
            }

        }
          */

        String a ="Enter memory required for process";
        System.out.println(a +" "+noOfProcess+" "+Array_Size);

        processSize=input_validatorLoop( a , noOfProcess , Array_Size);
        //display the output below
        System.out.println("\nNo. of Blocks available in memory -- "+noBlocks+"");

        //loop to produce the output
        for(i=0;i<noOfProcess && processInMem<noBlocks;i++)
        {
            //Display the following below
            System.out.print("\n\t" +(i+1)+"\t\t\t"+processSize[i]+"");
            if(processSize[i] > blockSize)
                System.out.print("\t\t\tNO\t\t\t\t---");
            else
            {
                System.out.print("\t\t\tYES\t\t\t\t"+(blockSize-processSize[i])+"");
                totInternalFragmentation = totInternalFragmentation + blockSize-processSize[i];
                processInMem++;
            }
        }
        if(i<noOfProcess)
            //Display the following below
            System.out.println("\nMemory is Full, Remaining Processes cannot be accomodated");
        System.out.println("\n\nTotal Internal Fragmentation is "+totInternalFragmentation+"");
        System.out.println("\nTotal External Fragmentation is "+externalFragmentation+"");

    }
    public  static void MVT(){

        //MVT
        //MVT variables
        int memoryAvailableV,iV, exFrag,nV=0;

        int[] availableMemory =new int[10] ;
        char ch = 'y';
        Scanner input=new Scanner(System.in);

        //display the output below
        System.out.println("\nEnter the total memory available (in Bytes)-- ");

        //input for Available Memory
        //memoryAvailableV=input.nextInt();
        memoryAvailableV=input_validator();
        //Available Memory assign to External Fragmentation
        exFrag=memoryAvailableV;

        //Loop to Accept Process input
        for(iV=0;ch=='y';iV++,nV++)
        {
            //display the output below
            System.out.println("\nEnter memory required for process "+(iV+1)+" (in Bytes) -- ");

            availableMemory[iV]=input.nextInt();
            if(availableMemory[iV]<=exFrag)
            {    //display the output below
                System.out.println("\nMemory is allocated for Process "+(iV+1)+" ");

                //calcuating the external fragmentation
                exFrag = exFrag - availableMemory[iV];
            }
            else
            {
                //display the output below
                System.out.println("\nMemory is Full");
                break;
            }
            //display the output below
            System.out.println("\nDo you want to continue(y/n) -- ");
            //Input to continue MVP
            ch=input.next().charAt(0);

        }
        //display the output below
        System.out.println("\n\nTotal Memory Available --"+memoryAvailableV+" ");
        System.out.println("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");
        for(iV=0;iV<nV;iV++)
            System.out.println("\n \t"+(iV+1)+"\t\t\t\t"+availableMemory[iV]+"");
        System.out.println("\n\nTotal Memory Allocated is " +(memoryAvailableV-exFrag)+"");
        System.out.println("\nTotal External Fragmentation is "+exFrag+"");




    }
    public  static void worstFit(){
        int max=25;
        /*
         * i - counter
         * j - counter 2
         * nb - number of blocks
         * nf - number of files
         * b - blocks
         * f -files
         * temp - internal fragmentation size
         * frag - Internal Fragmentation
         * */
        int i,j,nb,nf,temp =0;
        // frag[max],b[max],f[max]
        int[] frag = new int[max];
        int[] b = new int[max];
        int[] f = new int[max];


        //static int bf[max],ff[max];
        int[] bf = new int[max];
        int[] ff = new int[max];

        Scanner input = new Scanner(System.in);

        System.out.println("\n\tMemory Management Scheme - First Fit");
        System.out.println("\nEnter the number of blocks:");

        nb=input.nextInt();
        System.out.println("Enter the number of files:");

        nf=input.nextInt();
        System.out.println("\nEnter the size of the blocks:-\n");
        for(i=1;i<=nb;i++)
        {
            System.out.println("Block "+i);

            b[i]=input.nextInt();
        }
        System.out.println("Enter the size of the files :-\n");
        for(i=1;i<=nf;i++)
        {
            System.out.println("File "+i);

            f[i]=input.nextInt();
        }
        for(i=1;i<=nf;i++)
        {
            for(j=1;j<=nb;j++)
            {
                if(bf[j]!=1)
                {
                    temp=b[j]-f[i];
                    if(temp>=0)
                    {
                        ff[i]=j;
                        break;
                    }
                }
            }
            frag[i]=temp;
            bf[ff[i]]=1;
        }
        System.out.println("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");
        for(i=1;i<=nf;i++)
            System.out.println("\n  "+i+"\t\t\t\t"+f[i]+"\t\t\t"+ff[i]+"\t\t\t"+b[ff[i]]+"\t\t\t"+frag[i]);


    }
    public  static void bestFit(){
        /*
         * i - counter
         * j - counter 2
         * nb - number of blocks
         * nf - number of files
         * b - blocks
         * f -files
         * temp - internal fragmentation size
         * frag -  Internal Fragmentation
         * */
        int max=25;
        int i,j,nb,nf,temp,lowest=10000;
        //  frag[max],b[max],f[max],
        int[] frag = new int[max];
        int[] b = new int[max];
        int[] f = new int[max];

        // static int bf[max],ff[max];
        int[] bf = new int[max];
        int[] ff = new int[max];
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter the number of blocks:");

        nb=input.nextInt();
        System.out.println("Enter the number of files:");

        nf=input.nextInt();
        System.out.println("\nEnter the size of the blocks:-\n");
        for(i=1;i<=nb;i++) {
            System.out.println("Block " + i);

            b[i] = input.nextInt();
        }
        System.out.println("Enter the size of the files :-\n");
        for(i=1;i<=nf;i++)
        {
            System.out.println("File "+i);

            f[i]=input.nextInt();
        }
        for(i=1;i<=nf;i++)
        {
            for(j=1;j<=nb;j++)
            {
                if(bf[j]!=1)
                {
                    temp=b[j]-f[i];
                    if(temp>=0)
                        if(lowest>temp)
                        {
                            ff[i]=j;
                            lowest=temp;
                        }
                }
            }
            frag[i]=lowest;
            bf[ff[i]]=1;
            lowest=10000;
        }
        System.out.println("\nFile No\tFile Size \tBlock No\tBlock Size\tFragment");
        for(i=1;i<=nf && ff[i]!=0;i++)
            System.out.println("\n  "+i+"\t\t\t"+f[i]+"\t\t\t"+ff[i]+"\t\t\t"+b[ff[i]]+"\t\t\t"+frag[i]);

    }
    public  static void firstFit(){
        /*
         * i - counter
         * j - counter 2
         * nb - number of blocks
         * nf - number of files
         * b - blocks
         * f -files
         * temp - internal fragmentation size
         * frag - Internal Fragmentation
         * */
        int max = 25;
        int i,j,nb,nf,temp,highest=0;
        int[] frag=new int[max];
        int[] b=new int[max];
        int[] f=new int[max];


        int[] bf=new int[max];
        int[] ff=new int[max];

        Scanner input= new Scanner(System.in);


        System.out.println("\n\tMemory Management Scheme - Worst Fit");
        System.out.println("\nEnter the number of blocks:");

        nb=input.nextInt();
        System.out.println("Enter the number of files:");

        nf=input.nextInt();
        System.out.println("\nEnter the size of the blocks:-\n");
        for(i=1;i<=nb;i++)
        {
            System.out.println("Block :"+i);

            b[i]=input.nextInt();
        }
        System.out.println("Enter the size of the files :-\n");
        for(i=1;i<=nf;i++)
        {
            System.out.println("File :"+i);

            f[i]=input.nextInt();
        }
        for(i=1;i<=nf;i++)
        {
            for(j=1;j<=nb;j++)
            {
                if(bf[j]!=1) //if bf[j] is not allocated
                {
                    temp=b[j]-f[i];
                    if(temp>=0)
                        if(highest<temp)
                        {
                            ff[i]=j;
                            highest=temp;
                        }
                }
            }
            frag[i]=highest;
            bf[ff[i]]=1;
            highest=0;
        }
        System.out.println("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");
        for(i=1;i<=nf;i++){
            System.out.println("\n  "+i+"\t\t\t\t"+f[i]+"\t\t\t"+ff[i]+"\t\t\t"+b[ff[i]]+"\t\t\t"+frag[i]);

        }
    }
    public  static void paging(){

        int ms, ps, nop, np, rempages, i, j, x, y, pa, offset;


        int[] s =new int[10];
        int[][] fno =new int[10][20];

        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter the memory size -- ");

        ms=input.nextInt();
        System.out.println("\nEnter the page size -- ");

        ps=input.nextInt();
        nop = ms/ps;
        System.out.println("\nThe no. of pages available in memory are "+nop);
        System.out.println("\nEnter number of processes -- ");

        np=input.nextInt();
        rempages = nop;
        for(i=1;i<=np;i++)
        {
            System.out.println("\nEnter no. of pages required for "+i);

            s[i]=input.nextInt();
            if(s[i] >rempages)
            {
                System.out.println("\nMemory is Full");
                break;
            }
            rempages = rempages - s[i];
            System.out.println("\nEnter pagetable for "+i);
            for(j=0;j<s[i];j++)

                fno[i][j]=input.nextInt();
        }
        System.out.println("\nEnter Logical Address to find Physical Address ");
        System.out.println("\nEnter process no. and pagenumber and offset -- ");

        x=input.nextInt();
        y=input.nextInt();
        offset=input.nextInt();
        if(x>np || y>=s[i] || offset>=ps)
            System.out.println("\nInvalid Process or Page Number or offset");
        else
        {
            pa=fno[x][y]*ps+offset;
            System.out.println("\nThe Physical Address is "+pa);
        }

    }

    public  static void multilevel(){
        int i, k, n, temp;
        int[] p =new int[20];
        int[] bt =new int[20];
        int[] su =new int[20];
        int[] wt =new int[20];
        int[] tat =new int[20];

        float wtavg, tatavg;
        boolean flag = true;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of processes --- ");

        n=input.nextInt();


        /*
        * do {
            System.out.println("Enter the total memory available (in Bytes) -- ");
            //accepting availableMemorySize input
            try {
                processSizeS = input.nextLine();
                availableMemorySize = Integer.parseInt(processSizeS);
                if(availableMemorySize>0){
                    flag=false;
                }
            }catch(Exception e){
                System.out.println("invalid input \n Try again");
            }
        }while(flag);
        flag=true;
        *
        * */
        for(i=0;i<n;i++)
        {
            p[i] = i;
            System.out.println("Enter the Burst Time of Process "+ i);

            bt[i]=input.nextInt();
            System.out.println("System/User Process (0/1) ? --- ");

            su[i]=input.nextInt();
        }


        for(i=0;i<n;i++)
            for(k=i+1;k<n;k++)
                if(su[i] > su[k])
                {
                    temp=p[i];
                    p[i]=p[k];
                    p[k]=temp;
                    temp=bt[i];
                    bt[i]=bt[k];
                    bt[k]=temp;
                    temp=su[i];
                    su[i]=su[k];
                    su[k]=temp;
                }
        wtavg = wt[0] = 0;
        tatavg = tat[0] = bt[0];
        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] + bt[i-1];
            tat[i] = tat[i-1] + bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }
        System.out.println("\nPROCESS\t\t SYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for(i=0;i<n;i++)
            System.out.println("\n   "+p[i]+" \t\t\t\t "+su[i]+" \t\t\t\t   "+bt[i]+"\t\t\t\t"+wt[i]+" \t\t\t\t "+tat[i]+" ");
        System.out.println("\nAverage Waiting Time is --- "+wtavg/n);
        System.out.println("\nAverage Turnaround Time is --- "+tatavg/n);

    }
    public static void FCFS(){

        int  i, n;
        int[] bt = new int[20];
        int[] wt = new int[20];
        int[] tat = new int[20];
        float wtavg, tatavg;
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the number of processes -- ");

        n = input.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.println("\nEnter Burst Time for Process  -- "+ i);

            bt[i] = input.nextInt();
        }
        wt[0] = (int) (wtavg = 0);
        tat[0] = (int) (tatavg = bt[0]);
        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] +bt[i-1];
            tat[i] = tat[i-1] +bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }
        System.out.println("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
        for(i=0;i<n;i++)
            System.out.println("  \n\t\t "+i+" \t\t\t "+bt[i]+" \t\t\t "+wt[i]+" \t\t\t "+ tat[i]);
        System.out.println("\nAverage Waiting Time -- "+ wtavg/n);
        System.out.println("\nAverage Turnaround Time -- "+ tatavg+"\n\n");


    }
    public static void SJF(){

        int  i, k, n, temp;
        int[] p=new int[20];
        int[] bt=new int[20];
        int[] wt=new int[20];
        int[] tat=new int[20];
        float wtavg, tatavg;
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter the number of processes -- ");

        n=input.nextInt();
        for(i=0;i<n;i++)
        {
            p[i]=i;
            System.out.println("Enter Burst Time for Process  -- "+ i);

            bt[i]=input.nextInt();
        }
        for(i=0;i<n;i++)
            for(k=i+1;k<n;k++)
                if(bt[i]>bt[k])
                {
                    temp=bt[i];
                    bt[i]=bt[k];
                    bt[k]=temp;
                    temp=p[i];
                    p[i]=p[k];
                    p[k]=temp;
                }
        wt[0] = (int) (wtavg = 0);
        tat[0] = (int) (tatavg = bt[0]);
        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] +bt[i-1];
            tat[i] = tat[i-1] +bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }
        System.out.println("\n\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
        for(i=0;i<n;i++)
            System.out.println("  \n\t "+p[i]+" \t\t\t\t"+bt[i]+" \t\t\t "+wt[i]+" \t\t\t\t "+tat[i]);
        System.out.println("\nAverage Waiting Time -- "+ wtavg/n);
        System.out.println("\nAverage Turnaround Time --"+ tatavg/n);
    }
    public static void roundR(){
        int i,j,n,t,max;
        int[] bu=new int[10];
        int[] wa=new int[10];
        int[] tat=new int[10];
        int[] ct=new int[10];
        Scanner input = new Scanner(System.in);
        float awt=0,att=0,temp=0;

        System.out.println("Enter the no of processes -- ");

        n=input.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.println("\nEnter Burst Time for process  -- "+ (i+1));

            bu[i]=input.nextInt();
            ct[i]=bu[i];
        }
        System.out.println("\nEnter the size of time slice -- ");

        t=input.nextInt();
        max=bu[0];
        for(i=1;i<n;i++)
            if(max<bu[i])
                max=bu[i];
        for(j=0;j<(max/t)+1;j++)
            for(i=0;i<n;i++)
                if(bu[i]!=0)
                    if(bu[i]<=t)
                    {
                        tat[i]= (int) (temp+bu[i]);
                        temp=temp+bu[i];
                        bu[i]=0;
                    }
                    else
                    {
                        bu[i]=bu[i]-t;
                        temp=temp+t;
                    }
        for(i=0;i<n;i++)
        {
            wa[i]=tat[i]-ct[i];
            att+=tat[i];
        }
        System.out.println("\nThe Average Turnaround time is -- "+att/n);
        System.out.println("\nThe Average Waiting time is --  "+awt/n);
        System.out.println("\n\tPROCESS\t BURST TIME \t WAITING TIME\tTURNAROUND TIME\n");
        for(i=0;i<n;i++)
            System.out.println("\t  "+(i+1)+" \t\t "+(ct[i])+" \t\t\t\t"+(wa[i])+" \t\t\t\t "+(tat[i])+ "\n");
    }
    public static void priority(){
        int i, k, n, temp;
        int[] p= new int[20];
        int[] bt= new int[20];
        int[] pri= new int[20];
        int[] wt= new int[20];
        int[] tat= new int[20];
        float wtavg, tatavg;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of processes --- ");

        n= input.nextInt();
        for(i=0;i<n;i++)
        {
            p[i] = i;
            System.out.println("Enter the Burst Time --- "+i);
            bt[i] = input.nextInt();
            System.out.println("Enter the Burst  Priority of Process--- "+i);
            pri[i]= input.nextInt();
        }
        for(i=0;i<n;i++)
            for(k=i+1;k<n;k++)
                if(pri[i] > pri[k])
                {
                    temp=p[i];
                    p[i]=p[k];
                    p[k]=temp;
                    temp=bt[i];
                    bt[i]=bt[k];
                    bt[k]=temp;
                    temp=pri[i];
                    pri[i]=pri[k];
                    pri[k]=temp;
                }
        wtavg = wt[0] = 0;
        tatavg = tat[0] = bt[0];
        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] + bt[i-1];
            tat[i] = tat[i-1] + bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }
        System.out.println("\nPROCESS\t\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for(i=0;i<n;i++)
            System.out.println("\n"+p[i]+" \t\t\t "+pri[i]+" \t\t\t\t"+bt[i]+" \t\t\t "+wt[i]+" \t\t\t\t "+tat[i]);
        System.out.println("\nAverage Waiting Time is --- "+wtavg/n);
        System.out.println("\nAverage Turnaround Time is --- "+tatavg/n);



    }

    public static void bankers(){




        int allocated[][] = new int [10][10];
        int max[][] = new int [10][10];
        int need[][] = new int [10][10];
        int flag[] = new int [10];
        int fl;
        //loops
        int i;
        int j;
        int k;
        int p;

        int b;

        int n;
        int r;
        int g;
        int cnt = 0;
        int id;
        int newr;
        int avail[] = new int[10];
        int seq[] = new int[10];
        boolean yes = false;

        Scanner input = new Scanner(System.in);



        System.out.println("**** Bankers Algorithm ****\n");
        System.out.println("Enter number of processes -- ");
        n = input.nextInt();
        System.out.println("Enter number of resources -- ");
        r = input.nextInt();


        allocated = new int[n][r];
        max = new int[n][r];

        for (i = 0; i < n; i++) {
            System.out.println("Enter details for "+ i);
            System.out.println("\nEnter allocation\t -- \t");
            for (j = 0; j < r; j++){
                allocated[i][j] = input.nextInt();

            }
            System.out.println("Enter Max\t\t -- \t");
            for (j = 0; j < r; j++){
                max[i][j] = input.nextInt();
            }

            flag[i] = 0;
        }

        System.out.println("\nEnter Available Resources\t -- \t");
        for (i = 0; i < r; i++){
            avail[i] = input.nextInt();
        }


        System.out.println("\nEnter New Request Details -- ");
        System.out.println("\nEnter pid \t -- \t");
        id = input.nextInt();
        System.out.println("Enter Request for Resources \t -- \t");

        for (i = 0; i < r; i++) {
            newr = input.nextInt();
            // f[id].all[i] += newr;
            allocated[id][i] += newr;           // add the newr to the process' resource
            avail[i] = avail[i] - newr;     // subtract the newr from the avail
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < r; j++) {
                // f[i].need[j] = f[i].max[j] - f[i].all[j];
                need[i][j] = max[i][j] - allocated[i][j];

                if (need[i][j] < 0)
                    need[i][j] = 0;     // need is initialize to 0 if it is less than 0
            }
        }

        cnt = 0;
        fl = 0;

        while (cnt != n) {
            g = 0;
            for (j = 0; j < n; j++) {

                // check if a process is not finished,
                // this is determined by the flag value 0
                if (flag[j] == 0) {
                    b = 0;
                    for (p = 0; p < r; p++) {
                        if (avail[p] >= need[j][p])
                            b = b + 1;
                        else
                            b = b - 1;
                    }

                    // if all needs of p above are satisfied
                    if (b == r) {
                        System.out.printf("\nP%d is visited", j);
                        seq[fl++] = j;                          // add the process to the seq[] list
                        flag[j] = 1;                            // to indicate the process is in safe mode
                        for (k = 0; k < r; k++)
                            avail[k] = avail[k] + allocated[j][k];    // add allocation to available since
                        cnt = cnt + 1;                          // increament cnt by 1
                        System.out.println("(");
                        // the loop displays the available elements
                        for (k = 0; k < r; k++)
                            System.out.println( avail[k]);
                        System.out.println(")");
                        g = 1;
                    }
                }
            }

            // if there is a deadlock display this
            if (g == 0) {
                System.out.println("\n REQUEST NOT GRANTED -- DEADLOCK OCCURRED");
                System.out.println("\n SYSTEM IS IN UNSAFE STATE");
                // goto y;
                yes = true;
            }
        }

        // to implement goto
        if (yes == false) {
            System.out.println("\nSYSTEM IS IN SAFE STATE");
            System.out.println("\nThe Safe Sequence is -- (");

            for (i = 0; i < fl; i++)
                System.out.printf("P%d ", seq[i]);

            System.out.println(")");
        }

        // y:
        System.out.println("\nProcess\t\tAllocation\t\tMax\t\t\tNeed\n");
        for (i = 0; i < n; i++) {
            System.out.printf("P%d\t   ", i);
            for (j = 0; j < r; j++)
                System.out.printf("%6d", allocated[i][j]);
            for (j = 0; j < r; j++)
                System.out.printf("%6d", max[i][j]);
            for (j = 0; j < r; j++)
                System.out.printf("%6d", need[i][j]);
            System.out.printf("\n");
        }
        input.nextLine();
    }




    public static void jump(){

        for(i=0;i<n;i++)
        {
            System.out.println(i+"\t");
            for(j=0;j<r;j++)
                System.out.println(all[j]);
            for(j=0;j<r;j++)
                System.out.println(max[j]);
            for(j=0;j<r;j++)
                System.out.println(need[j]);
            System.out.println("\n");
        }
    }
    public static int input_validator(){
        boolean flag = true;
        String SSinput =null;
        int resultOut = 0;
        Scanner input =new Scanner(System.in);
        do {

            //accepting availableMemorySize input
            try {
                SSinput = input.nextLine();
                resultOut = Integer.parseInt(SSinput);
                if(resultOut>0){
                    flag=false;
                }
            }catch(Exception e){
                System.out.println("invalid input \n Try again");
            }
        }while(flag);

        flag=true;
        return resultOut;
    }
    public static int[] input_validatorLoop(String InnerString , int control,int arraySize){
        int in=0;
        int[] outputValue = new int[arraySize];
        String validateS = null;
        Scanner input = new Scanner(System.in);
        int counter =0;

        while(in<control)
        { counter+=1;
            // Display the output below
            System.out.println(InnerString+" "+(counter)+"  (in Bytes)-- ");
            try{
                validateS= input.nextLine();
                int processSizeI =0;
                processSizeI=Integer.parseInt(validateS);
                outputValue[in]=Integer.parseInt(validateS);
                if(processSizeI<=0){
                    in--;
                }else{
                    in++;
                }

            }catch (Exception e){
                System.out.println("invalid entry \n retry");
            }

        }
        return outputValue;
    }
//a) FCFS b) SJF c) Round Robin (pre-emptive) d) Priority

    public static void FCFS_DS(){
        int n, i, j, tot=0;

        int[] t = new int[20];
        int[] tohm = new int[20];
        float avhm;
        Scanner input = new Scanner(System.in);
        System.out.println("enter the no.of tracks");

        n=input.nextInt();
        System.out.println("enter the tracks to be traversed");
        for(i=2;i<n+2;i++)


            t[i]=input.nextInt();
        for(i=1;i<n+1;i++)
        {
            tohm[i]=t[i+1]-t[i];
            if(tohm[i]<0)
                tohm[i]=tohm[i]*(-1);
        }
        for(i=1;i<n+1;i++)
            tot+=tohm[i];
        avhm=(float)tot/n;
        System.out.println("Tracks traversed\tDifference between tracks\n");
        for(i=1;i<n+1;i++)
            System.out.println("   \t"+(t[i])+"\t\t\t\t\t\t"+tohm[i]+"\n");
        System.out.println("\nAverage header movements:"+avhm);

    }
    public static void scan(){

        int  h, i, j=0, n, temp, k,  tot, p, sum=0;
        int[] t = new int[20];
        int[] d = new int[20];
        int[] atr = new int[20];
        int[] tT = new int[20];
        int[] space = new int[20];
        int[] spaceS = new int[20];


        System.out.println("enter the no of tracks to be traveresed");

        n=input.nextInt();
        System.out.println("enter the position of head");

        h=input.nextInt();
        t[0]=0;t[1]=h;
        System.out.println("enter the tracks");
        for(i=2;i<n+2;i++)

            t[i]=input.nextInt();
        for(i=0;i<n+2;i++)
        {
            for(j=0;j<(n+2)-i-1;j++) {
                if(t[j]>t[j+1]) {
                    temp=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp;
                } } }
        for(i=0;i<n+2;i++)
            if(t[i]==h)
                j=i;k=i;
        p=0;
        //this is where t
        while(t[j]!=0)
        {
            atr[p]=t[j];
            j--;
            p++;
        }
        atr[p]=t[j];
        for(p=k+1;p<n+2;p++,k++)
            atr[p]=t[k+1];
        for(j=0;j<n+1;j++)
        {
            if(atr[j]>atr[j+1])
                d[j]=atr[j]-atr[j+1];
            else
                d[j]=atr[j+1]-atr[j];
            sum+=d[j];
        }
        for(int q = 1;q<=n;q++){

            space[q] =t[q]-t[(q-1)];

        }
        for(int q = 0;q<=n;q++){

            tT[q] = t[n-q];
            spaceS[q] = space[n-q];

        }

        System.out.println("Tracks traversed  \t\t Difference between track");

        for(int q = 0;q<=n-1;q++){
            System.out.println(tT[q+1]+ "\t\t\t\t\t\t\t\t"+spaceS[q] );
        }

        System.out.println("\nAverage header movements"+((float)sum/n));


    }
    public static void c_scanN(){
        int h, i, j=0, n, temp, k, tot, p, sum=0;
        int[] t= new int[20];
        int[] d= new int[20];
        int[] atr= new int[20];
        int[] tT= new int[20];
        int[] space= new int[20];
        int[] spaceS= new int[20];



        System.out.println("enter the no of tracks to be traveresed");

        n=input.nextInt();

        System.out.println("enter the position of head");

        h=input.nextInt();
        t[0]=0;t[1]=h;
        System.out.println("enter total tracks");

        tot=input.nextInt();
        t[2]=tot-1;
        System.out.println("enter the tracks");
        for(i=3;i<=n+2;i++)

            t[i]=input.nextInt();
        for(i=0;i<=n+2;i++)
            for(j=0;j<=(n+2)-i-1;j++)
                if(t[j]>t[j+1])
                {
                    temp=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp;
                }
        for(i=0;i<=n+2;i++)
            if(t[i]==h) {
                j = i;
                break;
            }
        p=0;
        while(t[j]!=tot-1)
        {
            atr[p]=t[j];
            j++;
            p++;
        }
        atr[p]=t[j];
        p++;
        i=0;
        while(p!=(n+3) && t[i]!=t[h])
        {
            atr[p]=t[i];
            i++;
            p++;
        }
        for(j=0;j<n+2;j++)
        {
            if(atr[j]>atr[j+1])
                d[j]=atr[j]-atr[j+1];
            else
                d[j]=atr[j+1]-atr[j];
            sum+=d[j];
        }
        for(int q = 1;q<=n;q++){

            space[q] =t[q]-t[(q-1)];

        }
        for(int q = 0;q<=n;q++){

            tT[q] = t[n-q];
            spaceS[q] = space[n-q];

        }

        System.out.println("total header movements"+sum);
        System.out.println("avg is "+((float)sum/n));


        for(int q = 0;q<=n;q++){

            System.out.println("this its"+t[q]);

        }

    }
    public static void main(String[] args){
        //variables for Validation
        int chh=0;
        String chho = null;
        Scanner input = new Scanner(System.in);

        //display the output below
        System.out.println("Memory Management techniques.");
        System.out.println("Select the Memory Management Technique You Want");
        System.out.println("***********************************************");
        do {
            //display the output below
            System.out.println(" Select 1 for MFT ");
            System.out.println(" Select 2 for MVT ");
            System.out.println(" Select 3 for WORST-FIT ");
            System.out.println(" Select 4 for BEST-FIT ");
            System.out.println(" Select 5 for FIRST-FIT ");
            System.out.println(" Select 6 for PAGING ");
            System.out.println(" Select 7 for multi-level queue scheduling ");
            //a) FCFS b) SJF c) Round Robin d) Priority
            System.out.println(" Select 8 for FCFS");
            System.out.println(" Select 9 for SJF");
            System.out.println(" Select 10 for Round Robin");
            System.out.println(" Select 11 for Priority");
            System.out.println(" Select 12 for Bankers Algorithm");
            //a) FCFS b) SCAN c) C-SCA
            System.out.println(" Select 13 for FCFS  In disc Scheduling");
            System.out.println(" Select 14 for SCAN");
            System.out.println(" Select 15 for C-SCA");
            System.out.println(" Select 0 To End  Program ");


            chho=input.nextLine();
            if(chho.equals("1")){


                MFT();
                System.out.println("\n\n******************");
                System.out.println("  * End of MFT *");
                System.out.println("******************\n\n\n");
            }else if(chho.equals("2")){

                // To MVT class
                MVT();
                System.out.println("\n\n******************");
                System.out.println("* End of MVT *");
                System.out.println("******************\n");
            }else if(chho.equals("3")){

                worstFit();
                System.out.println("\n\n********************");
                System.out.println("* End of Worst-Fit *");
                System.out.println("********************\n");
            }else if(chho.equals("4")){

                bestFit();
                System.out.println("\n\n*******************");
                System.out.println("* End of Best-Fit *");
                System.out.println("*******************\n");
            }else if(chho.equals("5")){
                firstFit();
                System.out.println("\n\n********************");
                System.out.println("* End of First-Fit *");
                System.out.println("********************\n");
            }else if(chho.equals("6")){
                paging();
                System.out.println("\n\n******************");
                System.out.println("* End of Paging *");
                System.out.println("******************\n");
            }else if(chho.equals("7")){

                multilevel();
                System.out.println("\n\n******************");
                System.out.println("* End of Multi-Level Queue Scheduling *");
                System.out.println("******************\n");
            }else if(chho.equals("8")){

                FCFS();
            }
            else if(chho.equals("9")){
                SJF();
            }
            else if(chho.equals("10")){
                roundR();
            }
            else if(chho.equals("11")){
                priority();
            }
            else if(chho.equals("12")){
                bankers();
            }
            else if(chho.equals("13")){
                FCFS_DS();
            }
            else if(chho.equals("14")){
                scan();
            }
            else if(chho.equals("15")){
                c_scanN();
            }
            else if(chho.equals("0")){
                System.out.println("\n\n******************");
                System.out.println("* End of Program *");
                System.out.println("******************\n");
                break;
            } else{

                System.out.println("*******************");
                System.out.println("*** WRONG ENTRY ***");
                System.out.println("****** RETRY ******");
                System.out.println(" ENTER ONLY DIGITS ");
                System.out.println("*******************\n");

            }
        }while(!chho.equals("1")||!chho.equals("2") || !chho.equals("3") || !chho.equals("4")|| !chho.equals("5") || !chho.equals("6")||!chho.equals("7") );

    }
}
