# urlhistory
API for url history tracker

## original plan for rdbs model design (dropped rating table)
<img src="https://user-images.githubusercontent.com/31434297/193477450-d8a6b2c8-709b-4517-a6fd-10c854353d04.png" width="428" height="191"/>


Asked but not implemented crossed out\

## URL history data maintains a list of URLs on a per user basis.

• Persist the data in a database, on a per user basis. Suggestion: use H2 or Derby in files.
• Provide an association between a user-defined name and a URL.\
• Provide a method to query the visitation count of a URL.\
• Provide a method to query the last visitation date of a URL.\
• Provide a method for a user to give personal ratings (a numerical value) to a URL.

## Grouping of URLs
### URLs can be put into one or more groups defined by the user

• Groups can be nested.\
• Groups never expire.

## Sorting Criteria
### The URLs of a user can be sorted by at least these criteria

~~• Sort URLs by Visitation Counts.~~\
~~• Sort URLs by Last Visitation Date.~~\
~~• Sort URLs by Personal Ratings.~~\
~~• Sort URLs by multiple criteria.~~\
~~• Sorting can be done in ascending or descending order.~~

## Storage Limits
• URL history data is maintained up to a user-defined length of time.\
• URL history data is maintained up to a user-defined maximum number of entries.\
• Expired items will be purged from persistent storage automatically.\
• URL entries can be flagged as “never-expire”, so that the entries will not be purged from the system.

## Inputs & Outputs
~~Inputs: the URLs that the user visits are given to this component as they become available.~~\
~~Outputs: the sorted list of URLs can be queried at any time by the user or another component.~~
