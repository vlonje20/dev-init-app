# Jenkins Pipeline Jobs:
   - Dashboard ==> + New Item ==> 
   - Project Name ==> Pipeline ==> OK

## Configure Pipeline Jobs: 
   - Project Name ==> Configure 
   - Genaral: 
        - Discard old builds: 
            - Strategy: Log Rotation 
            - Dayes to keep buiilds: (chose of leave blank for less than a day)
            - Max 3 of builds to keep: (eg: 3)

   - This project is parameterized:
        - Create parameter 

   - Build Triggers: 
        - Poll SCM 
        - Schedule: * * * * * (5 times with space)

## Pipeline 
   - Definition: 
        - Pipeline script: