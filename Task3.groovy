import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.comments.Comment
import com.atlassian.jira.issue.comments.CommentManager
import com.atlassian.jira.component.ComponentAccessor



import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.security.JiraAuthenticationContext
import com.atlassian.jira.user.ApplicationUser

// Get the login user
JiraAuthenticationContext authContext = ComponentAccessor.getJiraAuthenticationContext();
ApplicationUser appUser = authContext.getLoggedInUser();

ComponentAccessor componentAccessor = new ComponentAccessor();
IssueManager issueManager = componentAccessor.getIssueManager();

// Define issue
MutableIssue issue = event.getIssue() as MutableIssue;

// Get last comment
def commentManager = ComponentAccessor.getCommentManager()
def comment = commentManager.getLastComment (issue)
def data = comment.body + "\nAuthor: " + comment.authorFullName

// Set Description
issue.setDescription(data);

// Update it to the issue
issueManager.updateIssue(appUser, issue, EventDispatchOption.ISSUE_UPDATED, false);


