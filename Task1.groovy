import com.atlassian.jira.component.ComponentAccessor

def issueManager = ComponentAccessor.issueManager

// Get the fields by their names
def v1 = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("Number1") 
def v2 = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("Number2")

// Get the field values for calculation
def i = (issue.getCustomFieldValue(v1) ?: 0)
def j = (issue.getCustomFieldValue(v2) ?: 0)

return (i ?: 0) + (j ?: 0)