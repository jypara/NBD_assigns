printjson(
db.people.aggregate(
   [  { $unwind: "$credit" },
     {
       $group:
         {
           _id: "$credit.currency",
           total: { $sum: "$credit.balance" }
         }
     },  {$sort:{ _id:1}}
   ]
).toArray())
