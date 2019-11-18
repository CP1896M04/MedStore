from datetime import timedelta, date

def daterange(date1, date2):
    for n in range(int ((date2 - date1).days)+1):
        yield date1 + timedelta(n)

start_dt = date(2019, 1, 1)
end_dt = date(2019, 11, 12)
for dt in daterange(start_dt, end_dt):
    #print(dt.weekday())
    if(dt.weekday() !=0):
        print(dt.strftime("%Y-%m-%d"))
    
    
