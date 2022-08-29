def subTaskSum = 0

issue.getSubTaskObjects()?.each {subtask -> 
    subTaskSum ++
}
return subTaskSum