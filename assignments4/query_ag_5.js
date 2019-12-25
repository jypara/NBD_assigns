printjson(
db.people.aggregate(
   [  { $unwind: "$credit" },
{ $match : { sex : "Female" } },   
  {
       $group:
         {
           _id: "$credit.currency",
           avgBalance: { $avg: "$credit.balance" },
           total: { $sum: "$credit.balance" }
         }
     },  {$sort:{ _id:1}}
   ]
).toArray())
