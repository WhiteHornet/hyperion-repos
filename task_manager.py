import datetime 
from datetime import date

user = {}
with open("user.txt","r") as f:
    for line in f:
        line = line.replace("\n","")
        usl = line.split(", ")#reads through the dictionaary to access the username and password
        user[usl[0]] = usl[1]

theirUsername = input("What is your username?\n") 
theirPassword = input("What is your password?\n")

while True:
    if user[theirUsername] == theirPassword:
        print('login successfull')
        break#loops the login until given the correct username and password
    print('Wrong login details, try again')
    theirUsername = input("What is your username?\n") 
    theirPassword = input("What is your password?\n")
ch = ""

def register_User():
    username1 = ""
    while True:
        username1 = input("input new username\n")
        if user.get(username1):
            print("username already exists")
        else:
            break
    
    password1 = input("input new password\n")#replaces the previous username and password
    confirm = input ("confirm paswword\n")

    while password1 != confirm:
        print("type in password again")
        password1 = input("input new password\n")#replaces the previous username and password
        confirm = input ("confirm paswword\n")

    with open("user.txt","a")as g:
        g.write("\n"+username1 +", "+  password1)
    print("you have registered a new user")

def newtask():
    task_add = open("tasks.txt", "r+")

    us = input("Enter username: ")
    tasktitl = input("Enter task title: ")
    descr = input("Enter task description: ")
    dueDate = input("Enter due date: ")
    current_date = date.today().__format__("%d %b %Y")

    task_add.read()
    task_add.write("\n" + us+ ", "+ tasktitl +", "+descr+", "+current_date+", "+dueDate+", No")
    print("task has been added")

def viewtask():
    with open("tasks.txt", "r") as g:
        for line in g:
            line = line.replace("\n","")
            lis = line.split(", ")
            print("\nTask: "+ lis[1])
            print("Assigned to: "+ lis[0])
            print("Task Description: "+ lis[2])
            print("Date Assigned: "+ lis[3])
            print("Due Date: "+ lis[4])
            print("Task Complete?: "+ lis[5])
        print(g.read)

def mytasks():
    task_num = 0
    task_list = []
    with open("tasks.txt","r") as k:
        for line in k:
            line = line.replace("\n","")
            lis = line.split(", ")
            task_list.append(lis)
            if theirUsername == lis[0]:
                print("\ntask Identification: " + str(task_num))
                print("Task: "+ lis[1])
                print("Assigned to: "+ lis[0])
                print("Task Description: "+ lis[2])
                print("Date Assigned: "+ lis[3])
                print("Due Date: "+ lis[4])
                print("Task Complete?: "+ lis[5])
            task_num += 1
        ch = int(input("select task of choice or press -1 to return"))
        while ch != -1:
            if ch >= 0 and ch < task_num:
                select_tsk = task_list[ch]
                ch2 = int(input("enter 1 to mark the task as complete or enter 2 to edit task"))
                if ch2 == 1:
                    if select_tsk[-1].lower() == "no":
                        select_tsk [-1]= "yes"
                        print("task has been marked as completed")
                    else:
                        print("task has already been completed")
                elif ch2 == 2:
                    ch3 = int(input("enter 1 to edit task or enter 2 to edit the due date"))
                    if ch3 == 1:
                        nu = input("please enter a new username")
                        select_tsk[0] = nu
                        print("username has been updated")
                    elif ch3 == 2:
                        ndd = input("please enter new due date")
                        select_tsk[4] = ndd
                task_list[ch] = select_tsk
            elif ch == -1:
                print("Thank the tasks have been updated\n")
            else:
                print("you selection is out of range, please try again: \n")
            ch = int(input("select task of choice or press -1 to return"))
        t = open("tasks.txt", "w")
        t.flush()
        fc = ""
        for ta in task_list:
            fc += ", ".join(ta)
            fc +="\n"
        fc = fc.strip("\n")
        t.write(fc)
        t.close()


        

def user_overviw(us):
    user_tasks = 0
    per_num_task = 0
    per_task_assign_complete = 0
    per_task_assign_incomplete = 0
    per_task_incomplete_and_overdue = 0
    all_tasks = 0
    percen_task_comp = 0
    percen_task_incomp = 0
    percen_task_incomp_ove = 0

    with open("tasks.txt", "r") as l:
        for line in l:
            line = line.replace("\n","")
            lis = line.split(", ")
            all_tasks += 1
            if us == lis[0]:
                user_tasks += 1
                if lis[5].lower() == "no":
                    per_task_assign_incomplete += 1
                else:
                    per_task_assign_complete += 1
            strdate = lis[4]
            date_object = datetime.datetime.strptime(strdate,"%d %b %Y").date()
            if date_object < date.today():
                per_task_incomplete_and_overdue += 1
        if user_tasks > 0:
            percen_task_comp = per_task_assign_complete /user_tasks*100
            percen_task_incomp = per_task_assign_incomplete/user_tasks*100
            percen_task_incomp_ove = per_task_assign_incomplete/user_tasks *100
        usr_over = "welcome  "+us 
        usr_over +="\nlist of tasks they have done is: " +str(user_tasks)
        usr_over +=" \npercentage of tasks they have done is: "+ str(user_tasks/all_tasks*100) 
        usr_over +="percentage of tasks completed: "+str(percen_task_comp)
        usr_over +="\npercentage of tasks incompleted: "+str(percen_task_incomp)
        usr_over +="percentage of tasks incomplete and overdue: "+str(percen_task_incomp_ove)+"%\n----\n"
        return usr_over

def task_overview():
    with open("tasks.txt", "r") as l:
        number_of_tasks = 0
        completed_tasks = 0
        uncompleted_tasks = 0
        overdue_tasks = 0
        per_task_overdue = 0
        per_task_incomplete = 0
        for line in l:
            line = line.replace("\n","")
            lis = line.split(", ")
            number_of_tasks += 1
            if lis[5].lower() == "no":
                uncompleted_tasks += 1
            else:
                completed_tasks += 1
            
            strdate = lis[4]
            date_object = datetime.datetime.strptime(strdate,"%d %b %Y").date()
            if date_object < date.today():
                overdue_tasks += 1
        tsk_ovr = "number of tasks: "+ str(number_of_tasks)
        tsk_ovr += "\nuncompleted tasks: "+str(uncompleted_tasks)
        tsk_ovr +="\ncompleted tasks: "+str(completed_tasks)
        tsk_ovr +="\noverdue tasks: "+str(overdue_tasks)
        tsk_ovr +="\npercentage for overdue: "+str(overdue_tasks/number_of_tasks *100)
        tsk_ovr +="%"+"\npercentag for incompleter: "+str(uncompleted_tasks/number_of_tasks*100)+"%"
        return tsk_ovr
def reports():
    f = open("tasks_overview.txt","w")
    userdata2 = task_overview()
    f.write(userdata2)
    
    r = open("user_overview.txt", "w")
    number_of_users = 0
    number_of_tasks = 0
    userdata = ""
    with open("tasks.txt", "r") as l:
        for line in l:
            number_of_tasks += 1
    for key in user.keys():
        userdata += user_overviw(key)
        number_of_users += 1
    r.write("total number of tasks is: "+str(number_of_tasks)+"\n total number of usersu is: "+str(number_of_users)+ userdata)


def stats():
    reports()
    to = open("tasks_overview.txt","r")
    ds = to.read()
    print(ds)
    uo = open("user_overview.txt", "r")
    do = uo.read()
    print(do)


    
             
                

def overview():
    with open("tasks.txt", "r") as l:

        number_of_tasks = 0
        completed_tasks = 0
        uncompleted_tasks = 0
        overdue_tasks = 0
        per_task_overdue = 0
        per_task_incomplete = 0
        for line in l:
            line = line.replace("\n","")
            lis = line.split(", ")
            number_of_tasks += 1
            if lis[5].lower() == "no":
                uncompleted_tasks += 1
            else:
                completed_tasks += 1
            
            strdate = lis[4]
            date_object = datetime.datetime.strptime(strdate,"%d %b %Y").date()
            if date_object < date.today():
                overdue_tasks += 1
        print("number of tasks",number_of_tasks)
        print("uncompleted tasks",uncompleted_tasks)
        print("completed tasks",completed_tasks)
        print("overdue tasks", overdue_tasks)
        print("percentage for overdue", overdue_tasks/number_of_tasks *100,"%")
        print("percentag for incompleter", uncompleted_tasks/number_of_tasks*100,"%")

while 1:
    if theirUsername == "admin":
        ch = input("please select the following options: "+
            "\nr-register user\na-add task\nva-view all task\nvm- view my tasks"+
            "\ngr- generate report\nds-display statistics\ne-exit\n")
    else:
        ch = input("please select the following options:\na-add task\nva-view all task"+
                "\nvm- view my tasks\ne-exit\n")

    if ch == "r":
        if theirUsername == "admin":
            register_User()
        else:
            print("acess denied")
    elif ch == "a" : #adds tasks to the tasks.txt
        newtask()
    elif ch == "va":#opens and reads the tasks.txt
        viewtask()
    elif ch == "vm":# reads seperate taks
        mytasks()
    elif ch == "gr":
        reports()
    elif  ch == "ds":
        stats()
    elif ch == "e":#exits program
        break