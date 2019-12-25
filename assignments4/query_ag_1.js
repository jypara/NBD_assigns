printjson(
db.people.aggregate(
   [
     {
       $group:
         {
           _id: "$sex",
           avgHeight: { $avg: "$height" },
           avgWeight: { $avg: "$weight" }
         }
     }
   ]
) .toArray())
