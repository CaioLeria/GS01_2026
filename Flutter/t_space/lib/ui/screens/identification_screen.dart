import 'package:flutter/material.dart';
import 'package:t_space/config/app_routes.dart';
import 'package:t_space/ui/components/header.dart';

class IdentificationScreen extends StatefulWidget {
  const IdentificationScreen({super.key});

  @override
  State<IdentificationScreen> createState() => _IdentificationScreenState();
}

class _IdentificationScreenState extends State<IdentificationScreen> {
  String _name = '';
  String? _nameError;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Header(showBackButton: false, userName: null),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Card(
            elevation: 4,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(16),
            ),
            child: Padding(
              padding: const EdgeInsets.all(24.0),
              child: SizedBox(
                width: 400,
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    const Text(
                      'Como podemos te chamar?',
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    const SizedBox(height: 32),
                    TextField(
                      onChanged: (value) => setState(() {
                        _name = value;
                        _nameError = null;
                      }),
                      decoration: InputDecoration(
                        labelText: 'Nome',
                        errorText: _nameError,
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(8),
                        ),
                      ),
                    ),
                    const SizedBox(height: 24),
                    ElevatedButton(
                      onPressed: () {
                        if (_name.trim().isEmpty) {
                          setState(() {
                            _nameError = 'Como podemos te chamar?';
                          });
                          return;
                        }
                        Navigator.pushReplacementNamed(
                          context,
                          AppRoutes.home,
                          arguments: _name.trim(),
                        );
                      },
                      child: const Text('Continue'),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
