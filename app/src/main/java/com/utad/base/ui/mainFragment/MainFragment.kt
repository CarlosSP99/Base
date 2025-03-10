package com.utad.base.ui.mainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.utad.base.R
import com.utad.base.adapter.RopaAdapter
import com.utad.base.databinding.FragmentMainBinding
import com.utad.base.model.Ropa
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainFragmentViewModel by viewModels()
    private lateinit var adapter: RopaAdapter

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentMainBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment


        initUI()
        return binding.root
    }

    private fun initUI() {
        binding.title.text="Hombre"
        createRV()
        loadData()
    }

    private fun loadData() {
        lifecycleScope.launch {
            viewModel.uiState.collect{
                binding.pbLoading.visibility = if (it.isLoading) View.VISIBLE else View.GONE
                adapter.ropaList=it.ropaList
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun createRV() {
        adapter= RopaAdapter(
            ropaList = emptyList(),
            {moveToDetails(it)})
        binding.rvRopa.adapter=adapter
    }

    private fun moveToDetails(ropa: Ropa) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment(ropa.id))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivMenu = view.findViewById<AppCompatImageView>(R.id.ivMenuLogo)

        ivMenu.setOnClickListener { showPopupMenu(it) }
    }


    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_main, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_mujer -> {
                    binding.title.text="Mujer"

                    viewModel.fetchDataMujer()
                    true
                }
                R.id.menu_hombre -> {
                    binding.title.text="Hombre"
                    viewModel.fetchDataHombre()
                    true
                }
                R.id.menu_joyeria -> {
                    binding.title.text="Joyeria"

                    viewModel.fetchDataJewelery()
                    true
                }
                R.id.menu_electronica -> {
                    binding.title.text="Electronica"

                    viewModel.fetchDataElectornics()
                    true
                }


                else -> false
            }
        }

        popupMenu.show()
    }


}