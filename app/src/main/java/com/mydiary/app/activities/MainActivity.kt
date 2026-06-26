package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mydiary.app.R
import com.mydiary.app.adapters.NotesAdapter
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.utils.PrefsManager
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var prefs: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = PrefsManager.getInstance(this)

        setupRecyclerView()
        setupBottomNav()
        setupSearch()
        setupFab()
        observeNotes()
    }

    private fun setupRecyclerView() {
        notesAdapter = NotesAdapter { note -> openNote(note) }
        val rvNotes = findViewById<RecyclerView>(R.id.rvNotes)
        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.adapter = notesAdapter
    }

    private fun setupFab() {
        findViewById<FloatingActionButton>(R.id.fabAddNote).setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }

    private fun setupSearch() {
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setSearchQuery(query ?: "")
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.setSearchQuery(newText ?: "")
                return true
            }
        })
    }

    private fun setupBottomNav() {
        findViewById<View>(R.id.navPrivate).setOnClickListener {
            openPrivateFolder()
        }
        findViewById<View>(R.id.navCalendar).setOnClickListener {
            startActivity(Intent(this, CalendarActivity::class.java))
        }
        findViewById<View>(R.id.navImages).setOnClickListener {
            startActivity(Intent(this, VaultMediaActivity::class.java).apply {
                putExtra("media_type", "image")
            })
        }
        findViewById<View>(R.id.navSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun openPrivateFolder() {
        if (prefs.hasVaultPin()) {
            startActivity(Intent(this, SetPasswordActivity::class.java).apply {
                putExtra("mode", "verify_vault")
            })
        } else {
            // Show set password dialog
            showPrivateFolderSetupDialog()
        }
    }

    private fun showPrivateFolderSetupDialog() {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Private Folder")
            .setMessage("A passcode is required to access your private folder, where you can store your private images and videos.")
            .setPositiveButton("Set Password") { _, _ ->
                startActivity(Intent(this, SetPasswordActivity::class.java).apply {
                    putExtra("mode", "set_vault")
                })
            }
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()
    }

    private fun observeNotes() {
        viewModel.searchResults.observe(this) { notes ->
            notesAdapter.submitList(notes)
            val emptyView = findViewById<View>(R.id.layoutEmpty)
            val rvNotes = findViewById<RecyclerView>(R.id.rvNotes)
            if (notes.isEmpty()) {
                emptyView?.visibility = View.VISIBLE
                rvNotes.visibility = View.GONE
            } else {
                emptyView?.visibility = View.GONE
                rvNotes.visibility = View.VISIBLE
            }
        }
    }

    private fun openNote(note: DiaryNote) {
        startActivity(Intent(this, NoteDetailActivity::class.java).apply {
            putExtra("note_id", note.id)
        })
    }

    override fun onResume() {
        super.onResume()
    }
}
