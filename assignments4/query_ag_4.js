printjson(
db.people.aggregate(
   [ 
    {
     $addFields: {
       BMI:{$divide:[ "$weight",{$pow:[ {$divide :["$height",100]},2]}]}
       }},
{
       $group:
         {
           _id: "$nationality",
           avgBMI: { $avg: "$BMI" },
           minBMI: { $min: "$BMI" },
           maxBMI: { $max: "$BMI" }
         }
      },  {$sort:{ _id:1}}
  ]
).toArray())
