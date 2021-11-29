package com.boatList.listofboat.ui.boatlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boatList.listofboat.R
import com.boatList.listofboat.databinding.FragmentBoatListBinding
import com.boatList.listofboat.databinding.ItemTypeOfBoatBinding

class BoatListFragment : Fragment() {

    lateinit var items: Array<TypeOfBoat>

    private lateinit var boatListViewModel: BoatListViewModel
    private var _binding: FragmentBoatListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        items = arrayOf(TypeOfBoat("Sailing boats", R.drawable.voiliers, "As the name suggests, sailing ships are boats with sails propelled by the force of the wind. Before the invention of internal combustion engines, they were used for various marine activities: transport of people and goods, fishing, naval battles, etc."),
            TypeOfBoat("Fishing boats", R.drawable.barques_de_peches, "These are small fishing boats that are specially designed to navigate in shallow waters. A distinction is made between freshwater fishing boats and sea fishing boats, such as those designed by https://www.rigiflex.net Generally, these boats are made of composite materials such as polyethylene. They are therefore very robust and resistant to the aggressive agents present in the water and to UV rays."),
            TypeOfBoat("Folding boats", R.drawable.bateaux_gonflables, "Inflatable boats are small boats ranging from 2 to 10 metres in length. Practical and easy to transport, RIBs can be equipped with one or more outboard motors, in which case they are known as Zodiacs. RIBs are also widely used for bareboat charter. The interior of an inflatable boat is often made rigid with aluminium or plywood panels. Rigid inflatable boats have a solid hull and inflated tubes. The hull is usually made of steel, wood, or fibreglass. The tubes are made of PVC or polyurethane."),
            TypeOfBoat("Day-cruisers", R.drawable.day_cruisers, "As the name suggests, day-cruisers are motorboats designed to spend a day at sea. Measuring between 5 and 11 metres in length, they are equipped with a small cabin and possibly a small kitchenette. The day cruiser is ideal for fishing or water skiing. It is usually powered by an outboard engine. Larger boats can be equipped with an inboard engine."),
            TypeOfBoat("Headliners", R.drawable.vedettes, "The speedboat is a luxurious motorboat that is perfectly suited for coastal cruising. Like yachts, they are equipped with all the necessary equipment to ensure the comfort of passengers: hot water, air conditioning, heating, kitchen, berths, etc. Measuring 8 to 14 metres in length, they are usually powered by one or more inboard engines. Cruisers are available in several variants: open, hard-top, or flybridge."),
            TypeOfBoat("Cabin-cruisers", R.drawable.cabin_cruisers, "Halfway between day cruisers and speedboats, cabin cruisers are high-end cruise ships measuring between 7 and 14 metres in length. They are equipped with a cabin or a mid-cabin in which you can spend several nights. Smaller cabin cruisers are often powered by one or two outboard motors. Larger cabin cruisers are equipped with an inboard engine with a straight or hybrid Z-drive (or sterndrive)."),
            TypeOfBoat("Yachts", R.drawable.yachts, "A yacht is a symbol of social success and is a pleasure boat with many luxurious features. It is usually over 15 metres long and can accommodate several people on board in great comfort. Yachts are often designed individually by a naval architect. In yachting, a distinction is made between sailing yachts and motor yachts, which are often the stars of the Cannes boat show or the Nautic for example. The term \"super yacht\" is used when the length of the boat exceeds 40 metres and \"mega yacht\" when it exceeds 60 metres."),
            TypeOfBoat("Jet-boats", R.drawable.jet_boats, "A jet boat is a very fast boat powered by a water jet (like a jet ski). It is a compact marine propulsion system that pumps water under the boat and expels it at very high speed. A jet boat is between 4 and 8 metres long. It can accommodate up to 10 people and is particularly suitable for day cruising. Due to the absence of a propeller, this boat can easily navigate in shallow waters."),
            TypeOfBoat("Runabouts", R.drawable.runa_boats, "They are small boats of 5 to 7 metres in length that have a steering wheel, windscreen, and advanced controls for comfortable sailing. Runabouts can be powered by an outboard or inboard motor and are particularly popular for boat hire."),
            TypeOfBoat("Dinghies", R.drawable.dinghies, "Originally, the name Dinghy was used to designate the smallest boat in the British Royal Navy. Nowadays, this category of boat includes light boats without a cabin and with a length of up to 3 metres. A Dinghy is primarily a small, versatile pleasure boat that can be used for fishing or water sports activities. More affordable than other types of boats, it is a good choice for a person who wants to start boating. This name also refers to the tender of a boat, i.e. a service boat attached to a main vessel. The tender is often motorised but can also be rowed or sailed. The dinghy allows boaters to reach land from the anchorage."),
            TypeOfBoat("Sport fishing boats", R.drawable.bateaux_peches_sportives, "These are boats designed specifically for sport fishing. Their length generally varies from 10 to 30 metres. Sport fishing boats are usually powered by one or more inboard engines placed in the hull. They are spacious, robust and perfectly suited for chasing big fish on the high seas."),
            TypeOfBoat("Pontoon boats", R.drawable.bateaux_ponton, "With a length of 5 to 10 metres, a pontoon boat is a pleasure craft that comprises at least 2 cylindrical floats that are connected by a wooden or composite floor. Very stable, pontoon boats can be powered by an outboard or semi-outboard motor. They are designed for one or two day cruises and can accommodate up to 25 people."),
            TypeOfBoat("High performance boats", R.drawable.bateaux_hautes_perf, "High performance boats are intended mainly for racing or fast cruising. These boats, also known as offshore boats, are therefore designed to be agile, fast, light and robust. Like racing cars, they have a sleek and highly aerodynamic design. High performance boats are usually powered by powerful outboard or sterndrive engines. They range from 6 to 15 metres in length and can accommodate up to 6 people."))

        boatListViewModel =
            ViewModelProvider(this).get(BoatListViewModel::class.java)

        _binding = FragmentBoatListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        boatListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val typeOfBoatRecyclerView: RecyclerView = binding.typeOfBoatRecyclerView
        typeOfBoatRecyclerView.layoutManager = LinearLayoutManager(this.context)
        typeOfBoatRecyclerView.adapter = this.context?.let { TypeOfBoatAdapter(items, it) }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class TypeOfBoatAdapter(val items: Array<TypeOfBoat>, val cont: Context) : RecyclerView.Adapter<TypeOfBoatAdapter.ViewHolder>() {
        inner class ViewHolder(val binding: ItemTypeOfBoatBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bindTypeOfBoat(typeOfBoat: TypeOfBoat) {
                with(typeOfBoat) {
                    binding.typeOfBoatTxt.text = "$title"
                    binding.typeOfBoatImg.setImageResource(typeOfBoat.img)
                    binding.typeOfBoatImg.setOnClickListener {
                        val text = "$title"
                        val duration = Toast.LENGTH_SHORT
                        val toast = Toast.makeText(cont, text, duration)
                        toast.show()
                    }
                    binding.typeOfBoatInfo.text = "$info"
                }

            }
        }

        override fun getItemCount(): Int = items.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemTypeOfBoatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindTypeOfBoat(items[position])
        }
    }
}